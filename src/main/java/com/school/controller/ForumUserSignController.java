package com.school.controller;

import com.school.entity.TFkUserSign;
import com.school.entity.TForumArticle;
import com.school.entity.TUser;
import com.school.service.ForumArticleService;
import com.school.service.ForumUserSignService;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/28.
 * 用户收藏controller
 */
@RestController
@RequestMapping("/sign")
public class ForumUserSignController {
    @Autowired
    ForumUserSignService forumUserSignService;
    @Autowired
    ForumArticleService forumArticleService;
    @Autowired
    UserService userService;

    boolean b = false;

    /**
     * 判断用户是否收藏过
     *
     * @param userId    谁
     * @param articleId 是否关注的 文章
     * @return
     */
    @RequestMapping("/boolean")
    public boolean selectMeWhetherSign(int userId, int articleId) {

        b = forumUserSignService.selectMeWhetherSign(userId, articleId);
        return b;

    }

    /**
     * 添加收藏
     *
     * @param userId    谁
     * @param articleId 收藏文章_id
     * @return
     */
    @RequestMapping("/add")
    public boolean addSign(int userId, int articleId) {
        b = forumUserSignService.addSign(userId, articleId);
        return b;

    }

    /**
     * 删除收藏
     *
     * @param userId    谁
     * @param articleId 删除收藏文章_id
     * @return
     */
    @RequestMapping("/delete")
    public boolean deleteSign(int userId, int articleId) {
        b = forumUserSignService.deleteSign(userId, articleId);
        return b;

    }

    @RequestMapping("/meSign")
    public ModelAndView selectMeSign(Integer userId) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        if (userId != null) {
            List<TFkUserSign> uSign = forumUserSignService.selectMeSign(userId);
            List<Integer> li = new ArrayList<>();
            List<Integer> userList = new ArrayList<>();
            for (TFkUserSign tFkUserSign : uSign) {
                userList.add(tFkUserSign.getFkUserKey());
                li.add(tFkUserSign.getFkArticleKey());
            }
            List<TUser> tUserList = userService.selectUserIdIn(userList);
            List<TForumArticle> lfa = forumArticleService.selectFindById(li);
            modelAndView.addObject("articleSignUser",tUserList);
            modelAndView.addObject("articleAllSign", lfa);
        }
        return modelAndView;
    }


}
