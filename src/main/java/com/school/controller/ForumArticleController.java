package com.school.controller;


import com.school.entity.*;
import com.school.finals.FinalsString;
import com.school.service.*;
import com.school.util.StringUitl;
import com.school.util.UpLoadUtil;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Founder XiTao
 * @Create_Data 2018/12/20
 * @Filde：论坛文章控制层
 */
@RestController
@RequestMapping("/forum")
public class ForumArticleController {
    Logger log = LoggerFactory.getLogger(ForumArticleController.class);
    @Autowired
    ForumArticleService fas;
    @Autowired
    UserService userService;
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    @Autowired
    ForumMindService mindService;
    @Autowired
    ForumFansService forumFansService;
    @Autowired
    IntegralIcoService inte;
    @Autowired
    ForumCommentService forumCommentService;
    @Autowired
    ForumCommentReplyService forumCommentReplyService;
    @Autowired
    ForumUserSignService forumUserSignService;


    /**
     * 根据标题查询Article中 标题and内容相匹配
     *
     * @param title
     * @return Article Json
     */
    @RequestMapping("/article/like")
    public ModelAndView findByTitleAndContentLikeToArticle(String title) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticleVo> lfat = new ArrayList<>();
        try {
            if (title != null && !title.equals("")) {
                lfat = fas.findByTitleAndContentLikeToArticle(title);
            }
        } finally {

        }
        List<Integer> li = new ArrayList<>();
        for (TForumArticleVo tf : lfat) {
            try {
                if (tf.getFkUserKey() != null && tf.getFkUserKey().getId() > 0) {
                    li.add(tf.getFkUserKey().getId());
                    List<TUser> lu = userService.selectUserIdIn(li);
                    for (TUser tu : lu) {
                        for (TForumArticleVo tfa : lfat) {
                            if (tu.getId() == tfa.getFkUserKey().getId()) {
                                tfa.setFkUserKey(tu);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                log.info(e.toString());
            } finally {
            }
        }

        mav.addObject("farticle", lfat);
        return mav;
    }

    /**
     * 通过文章_ID 查询_文章内容_相关文章_评论内容_回复内容
     *
     * @param article_id
     * @return Article
     */
    @RequestMapping("/articleIdToArticle")
    public ModelAndView findByTitleToArticle(int article_id) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        //这篇文章
        TForumArticleVo articleVo = fas.findByTitleToArticle(article_id);
        Map map = new HashMap();
        try {
            if (articleVo != null) {
                //获取作者
                List<Integer> li = new ArrayList<>();
                li.add(articleVo.getFkUserKey().getId());
                List<TUser> lu = userService.selectUserIdIn(li);
                articleVo.setFkUserKey(lu.get(0));
                //作者等级图标_id
                int userExeICO = lu.get(0).getFkIntegralId();
                TIntegralIco UserIntegralIco = inte.selectFkIdICO(userExeICO);
                map.put("articleVo", articleVo);
                map.put("UserIntegralIco", UserIntegralIco);
                //评论查询
                List<TForumComment> articleCommentList = forumCommentService.selectFkIdToComment(articleVo.getId());
                //是否有评论
                if (articleCommentList != null) {
                    //评论人查询
                    List<Integer> lit = new ArrayList<>();
                    for (TForumComment fc : articleCommentList) {
                        lit.add(fc.getId());
                    }
                    List<TUser> articleCommentUserList = userService.selectUserIdIn(lit);
                    map.put("articleListComment", articleCommentList);
                    map.put("articleCommentUserList", articleCommentUserList);
                    //评论回复查询
                    List<TCommentReply> articleCommentReplyList = forumCommentReplyService.selectFkCommentIdToReply(lit);
                    //是否有评论回复
                    if (articleCommentReplyList != null) {
                        //评论回复人
                        List<Integer> litg = new ArrayList<>();
                        for (TCommentReply tCommentReply : articleCommentReplyList) {
                            litg.add(tCommentReply.getFkUserKey());
                        }
                        List<TUser> articleCommentReplyUserList = userService.selectUserIdIn(litg);
                        map.put("articleCommentReplyList", articleCommentReplyList);
                        map.put("articleCommentReplyUserList", articleCommentReplyUserList);

                    } else {
                        map.put("articleCommentReplyList", null);
                        map.put("articleCommentReplyUserList", null);
                    }

                } else {
                    //没有 评论-评论用户，回复-回复用户
                    map.put("articleCommentList", null);
                    map.put("articleCommentUserList", null);
                    map.put("articleCommentReplyList", null);
                    map.put("articleCommentReplyUserList", null);
                }
                //相关文章推荐
                String titleUtil = StringUitl.aString(articleVo.getTitle());
                List<TForumArticleVo> articleRelevantList = fas.findByTitleLikeLimite(titleUtil);
                if (articleRelevantList != null ) {
                    List<Integer> listInteger = new ArrayList<>();
                    for (TForumArticleVo tavo : articleRelevantList) {
                        listInteger.add(tavo.getFkUserKey().getId());
                    }
                    List<TUser> articleRelevantUserList = userService.selectUserIdIn(listInteger);
                    for (TUser tUser : articleRelevantUserList) {
                        for (TForumArticleVo tf : articleRelevantList) {
                            if (tUser.getId() == tf.getFkUserKey().getId()) {
                                while (tf.getFkUserKey().getId() == tUser.getId()) {
                                    tf.setFkUserKey(tUser);
                                    break;
                                }

                            }
                        }
                    }
                    map.put("articleRelevantList",articleRelevantList);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/addViolation")
    public boolean updateViolationCount(int articleId) {
        return fas.updateViolationCount(articleId);
    }

    @RequestMapping("/browseCount")
    public ModelAndView selectBrowseCount(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        Integer count = fas.selectBrowseCountArticle(userId);
        modelAndView.addObject("browseCount", count);
        return modelAndView;
    }

    @RequestMapping("/articleCount")
    public ModelAndView selectArticleCount(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        Long count = fas.selectArticleCount(userId);
        modelAndView.addObject("articleCount", count);
        return modelAndView;
    }

    @RequestMapping("/articleAllUser")
    public ModelAndView selectArticleAllUser(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticle> lfa = fas.selectArticleAll(userId);
        modelAndView.addObject("articleAll", lfa);
        return modelAndView;
    }

    @RequestMapping("/articleLimitUser")
    public ModelAndView selectArticleLimitUser(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticle> lfa = fas.selectLimitArticle(userId);
        modelAndView.addObject("articleLimit", lfa);
        return modelAndView;
    }


    /**
     * 添加文章
     *
     * @param tForumArticle
     * @return
     */
    @RequestMapping("/addArticle")
    public boolean addArticle(TForumArticle tForumArticle) {
        System.out.println(tForumArticle.toString());
        boolean b = false;
        //文件目录
        String path = FinalsString.PROJECT_STATIC_RESOURCE_PATH_TEXT;
        //文件名称
        String fileName = path + "/" + StringUitl.createStringRandomName();
        try {
            b = UpLoadUtil.writeDataInServlet(tForumArticle.getContentText(), fileName, path);
        } catch (Exception e) {
            b = false;
            return b;
        }

        if (b) {
            tForumArticle.setContentText(fileName);
            b = fas.addArticle(tForumArticle);
        }

        return b;

    }

    /**
     * 通过分类类型ID 查询 分类下的所有 文章
     *
     * @param id    类型
     * @param start 开始index
     * @param end   截止index
     * @return
     * @Param dateTime 时间
     */
    @RequestMapping("/singleTypeAll")
    public ModelAndView selectForumSingleType(int id, int start, int end, String dateTime) {
        System.out.println(id + "," + start + "," + end + "," + dateTime);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<TForumArticleVo> lfaVo = fas.findByFkTypeIdToArticle(id, start, end, dateTime);
        if (lfaVo.size() != 0) {
            List<Integer> li = new ArrayList<>();
            for (TForumArticleVo tf : lfaVo) {
                li.add(tf.getFkUserKey().getId());
            }
            List<TUser> lu = userService.selectUserIdIn(li);
            for (TUser tu : lu) {
                for (TForumArticleVo favo : lfaVo) {
                    if (tu.getId() == favo.getFkUserKey().getId()) {
                        favo.setFkUserKey(tu);
                    }
                }
            }
        }
        modelAndView.addObject("listTypeForumVo", lfaVo);
        return modelAndView;
    }

    /**
     * 根据用户_Id查询 用户信息
     * @param userId
     * @return
     */
    @RequestMapping("personalAllInfo")
    public ModelAndView selectPersonalAll(int userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        Map map = new HashMap();
        //查询最近动态
        List<TForumArticle> newsArticleList = fas.selectLimitArticle(userId);
        //查询动态用户
        List<Integer> integers = new ArrayList<>();
        for (TForumArticle forumArticle : newsArticleList) {
            integers.add(forumArticle.getFkUserKey());
        }
        List<TUser> newsUserList = userService.selectUserIdIn(integers);
        map.put("newsUserList", newsUserList);
        map.put("newsArticleList", newsArticleList);

        //个人发布过多少论坛
        Long totalArticleItem = fas.selectArticleCount(userId);
        map.put("totalArticleItem", totalArticleItem);
        //所有文章总浏览量
        Integer totalArticleBrowse = fas.selectBrowseCountArticle(userId);
        map.put("totalArticleBrowse", totalArticleBrowse);
        //粉丝数量
        Long  totalFansItem = forumFansService.selectCountFansUser(userId);
        map.put("totalFansItem", totalFansItem);
        //个人信息
        List<Integer> personId = new ArrayList<>();
        personId.add(userId);
        List<TUser> user = userService.selectUserIdIn(personId);
        map.put("user", user);
        try{
            TIntegralIco personIntegralIco = inte.selectFkIdICO(user.get(0).getFkIntegralId());
            map.put("personIntegralIco", personIntegralIco);
        }catch(NullPointerException |IndexOutOfBoundsException e ){
            System.out.println(e.toString());
        }
        //个人关注的数量
        Long totalMindItem = mindService.selectCountMindUser(userId);
        map.put("totalMindItem", totalMindItem);
        //个人收藏数量
        Long totalSignItem = forumUserSignService.selectSignCount(userId);
        map.put("totalSignItem", totalSignItem);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

}
