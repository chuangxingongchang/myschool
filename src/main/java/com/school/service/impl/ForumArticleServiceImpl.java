package com.school.service.impl;

import com.school.entity.TForumArticle;
import com.school.entity.TForumArticleExample;
import com.school.entity.TForumComment;
import com.school.entity.TUser;
import com.school.finals.FinalsString;
import com.school.mapper.TForumArticleMapper;
import com.school.service.ForumArticleService;
import com.school.util.DateUtil;
import com.school.util.IntUtil;
import com.school.util.StringUitl;
import com.school.util.UpLoadUtil;
import com.school.vo.TForumArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: XiTao
 * @Date: 2018/12/20
 * @Field: 论坛文章 实现层
 */
@Transactional
@Service
public class ForumArticleServiceImpl implements ForumArticleService {
    Logger log = LoggerFactory.getLogger(ForumArticleServiceImpl.class);
    @Autowired
    TForumArticleMapper tam;
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    private String url = FinalsString.PROJECT_STATIC_RESOURCE_PATH_TEXT + "/";

    public List<TForumArticleVo> findByTitleAndContentLikeToArticle(String likeTitle, int start, int end) {
        List<TForumArticleVo> lfa = new ArrayList<>();
        //标题equal
        Map map = new HashMap();
        map.put("likeTitle", likeTitle);
        map.put("start", start);
        map.put("end", end);
        List<TForumArticle> list = tam.selectTitleLimit(map);
        if (list != null && list.size() != 0) {
            for (TForumArticle tf : list) {
                lfa.add(get(tf));
            }
        }
        //内容equal
        List<TForumArticle> list1 = tam.selectContentLimit(map);
        if (list1 != null && list1.size() != 0) {
            for (TForumArticle tf : list1) {
                lfa.add(get(tf));
            }
        }
        //%标题%
        List<TForumArticle> list2 = tam.selectTitleLikeLimit(map);
        if (list2 != null && list2.size() != 0) {
            for (TForumArticle tf : list2) {
                lfa.add(get(tf));
            }
        }
        //%内容%
        List<TForumArticle> list3 = tam.selectContentLikeLimit(map);
        if (list3 != null && list3.size() != 0) {
            for (TForumArticle tf : list3) {
                lfa.add(get(tf));
            }
        }
        return lfa;
    }

    @Override
    public List<TForumArticleVo> findByFkTypeIdToArticle(int id, int start, int end, String dateTime) {
        List<TForumArticle> lfa;
        System.out.println(dateTime);
        List<TForumArticleVo> lfavO = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        //最新文章则不加条件 只排序 limit
        map.put("start", start);
        map.put("end", end);
        //判断分类
        if (id != 2) {
            if (id == 1) {
                map.put("dateTime","");
                map.put("order_desc", 1);
            } else {
                if(!dateTime.equals("2888-88-88")){
                    map.put("dateTime",dateTime);
                }else {
                    map.put("dateTime","");
                }
                map.put("order_desc", 2);
            }
            map.put("typeId", id);
            lfa = tam.selectLimitOrderTimeDescAndWhere(map);
        } else {
            if (dateTime.equals("2888-88-88")){
                lfa = tam.selectNewsArticle(map);
            }else{
                map.put("dateTime",dateTime);
                map.put("order_desc",2);
                lfa = tam.selectLimitOrderTimeDescAndWhere(map);
            }

        }
        for (TForumArticle tf : lfa) {
            lfavO.add(get(tf));
        }
        return lfavO;
    }

    @Override
    public TForumArticleVo findByTitleToArticle(int article_id) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or()
                .andIdEqualTo(article_id);
        List<TForumArticle> lfa = tam.selectByExample(fae);
        TForumArticleVo lfaVo = null;
        if (lfa.size() != 0) {
            for (TForumArticle tf : lfa) {
                updatePrivate("browse",tf);
                lfaVo = get(tf);
            }
        }
        return lfaVo;
    }

    @Override
    public List<TForumArticleVo> findByTitleLikeLimite(String title) {
        TForumArticleExample fae = new TForumArticleExample();
        List<TForumArticleVo> lfaVo = new ArrayList<>();
        fae.or()
                .andTitleLike("%" + title + "%");
        List<TForumArticle> lfa = tam.selectByExample(fae);
        if (lfa.size() >= 6) {
            for (int i = 0; i < 5; i++) {
                lfaVo.add(get(lfa.get(i)));
            }
        } else {
            for (TForumArticle tf : lfa) {
                lfaVo.add(get(tf));
            }
        }
        return lfaVo;
    }

    @Override
    public boolean updateCommentCount(int articleId) {
        boolean b = false;
        try {
            TForumArticleExample fae = new TForumArticleExample();
            fae.or().andIdEqualTo(articleId);
            List<TForumArticle> lfa = tam.selectByExample(fae);

            lfa.forEach(f -> {
                f.setCommentCount(f.getCommentCount() + 1);
            });
            int i = tam.updateByPrimaryKey(lfa.get(0));
            if (i != 0) {
                b = true;
            }
        } catch (Exception e) {
            return b;
        }
        return b;


    }

    @Override
    public boolean updateViolationCount(int articleId) {
        final boolean[] b = {false};
        TForumArticleExample fae = new TForumArticleExample();
        fae.or()
                .andIdEqualTo(articleId);
        List<TForumArticle> lfae = tam.selectByExample(fae);
        final Integer[] count = {1};
        TForumArticle fa = new TForumArticle();
        final int[] i = {0};
        try {
            lfae.forEach(f -> {
                if (StringUitl.stringFilter(f.getTitle()) && StringUitl.stringFilter(f.getContentText())) {
                    count[0] = count[0] + f.getViolationCount();
                    fa.setId(articleId);
                    fa.setViolationCount(count[0]);
                    i[0] = tam.updateByPrimaryKey(fa);
                } else {
                    b[0] = false;
                }
            });

            if (i[0] != 0) {
                b[0] = true;
            }
        }catch (Exception e){
            return false;
        }
            return b[0];

    }

    @Override
    public Integer selectBrowseCountArticle(int userId) {
        Integer i = 0;
        try {
            i = tam.selectBrowseCount(userId);
        } catch (Exception e) {
            return i;
        }
        return i;
    }

    @Override
    public List<TForumArticle> selectArticleAll(int userId) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or().andFkUserKeyEqualTo(userId);
        List<TForumArticle> lfa = tam.selectByExample(fae);
        try {
            for (TForumArticle tForumArticle : lfa) {
                tForumArticle.setContentText(UpLoadUtil.inputFileData(tForumArticle.getContentText()).toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lfa;
    }

    @Override
    public List<TForumArticle> selectLimitArticle(int userId) {
        return tam.selectLimitArticle(userId);
    }

    @Override
    public Long selectArticleCount(int userId) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or().andFkUserKeyEqualTo(userId);
        return (long) tam.countByExample(fae);
    }

    @Override
    public boolean addArticle(TForumArticle tForumArticle) {
        boolean b = false;
        tForumArticle.setBrowseConut(0);
        tForumArticle.setCommentCount(0);
       // tForumArticle.setCreateTime(DateUtil.getDate(DateUtil.getDATE()));
         tForumArticle.setCreateTime(new Date());
        tForumArticle.setViolationCount(0);
        tForumArticle.setFkApplaudStatus(0);
        tForumArticle.setFkApplaudStatus(0);
        tForumArticle.setIsNull("");
        tForumArticle.setIsNullInt(0);
        tForumArticle.setIsNullInt(IntUtil.getIntegerUUID());
        int i = tam.insert(tForumArticle);
        if (i != 0) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean updateArticle(TForumArticle tForumArticle) {
        boolean b = false;
        int i = 0;
        try {
            if (tForumArticle != null) {
                i = tam.updateByPrimaryKeySelective(tForumArticle);
                if (i != 0) {
                    b = true;
                }
            }
        } catch (Exception e) {
            return b;
        }
        return b;
    }

    @Override
    public List<TForumArticle> selectFindById(List<Integer> list) {
        TForumArticleExample fae = new TForumArticleExample();
        fae.or()
                .andIdIn(list);
        fae.setOrderByClause("create_time desc");
        List<TForumArticle> lfa = tam.selectByExample(fae);
        try {
            for (TForumArticle tForumArticle : lfa) {
                tForumArticle.setContentText(UpLoadUtil.inputFileData(tForumArticle.getContentText()).toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lfa;
    }

    @Override
    public boolean addListArticle(List<TForumArticle> listArticle) {
        boolean b = false;
        int i = 0;
        for (TForumArticle tForumArticle : listArticle) {
            TForumArticleExample tForumArticleExample = new TForumArticleExample();
            tForumArticleExample.or()
                    .andTitleEqualTo(tForumArticle.getTitle())
                    .andFkForumTypeKeyEqualTo(1)
                    .andContentTextEqualTo(tForumArticle.getContentText())
                    .andFkUserKeyEqualTo(tForumArticle.getFkUserKey());
            List<TForumArticle> list = tam.selectByExample(tForumArticleExample);
            if (list.size() == 0) {
                tForumArticle.setFkForumTypeKey(1);
                tForumArticle.setId(null);
                i = tam.insert(tForumArticle);
                if (i != 1) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        return false;
                    }
                }
                b = true;
            }


        }

        return b;
    }

    @Override
    public List<TForumArticle> selectPersonalAllArticle(int userId, int start, int end) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", start);
        map.put("end", end);
        List<TForumArticle> list = tam.selectPersonalAllArticle(map);
        if (list == null) {
            return null;
        }
        return list;
    }


    @Override
    public List<TForumArticle> selectPersonalArticle(int userId, int start, int end, String createTime) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("start", start);
        map.put("end", end);
        map.put("createTime", createTime);
        List<TForumArticle> list = tam.selectPersonalArticle(map);
        if (list == null) {
            return null;
        }
        return list;
    }

    //获取每个类型的最热门的10 条 数据
    @Override
    public List<TForumArticle> selectTypeLimitOrderDescBro(int type_id) {
        List<TForumArticle> list = tam.selectLimitOrderDescBrow(type_id);
            return list;
    }
    private boolean updatePrivate(String type,TForumArticle tForumArticle){
        TForumArticleExample tForumArticleExample = new TForumArticleExample();
        tForumArticleExample.or().andIdEqualTo(tForumArticle.getId());
        TForumArticle article = new TForumArticle();
        switch (type){
            case "browse" : {
                article.setBrowseConut(tForumArticle.getBrowseConut()+1);break;
            }
            case "comment":{
                article.setCommentCount(tForumArticle.getCommentCount()+1);break;
            }
        }
       int i =  tam.updateByExampleSelective(article,tForumArticleExample);
       return  IntUtil.addDeleteUpdate(i);
    }

    private TForumArticleVo get(TForumArticle tf) {
        TForumArticleVo avo = new TForumArticleVo();
        avo.setId(tf.getId());
        avo.setApplaud(tf.getFkApplaudStatus());
        try {
            avo.setContentText(UpLoadUtil.inputFileData(tf.getContentText()).toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        avo.setCommentCount(tf.getCommentCount());
        avo.setCreateTime(DateUtil.getDate(tf.getCreateTime()));
        avo.setViolationCount(tf.getViolationCount());
        avo.setTitle(tf.getTitle());
        TUser u = new TUser();
        u.setId(tf.getFkUserKey());
        avo.setFkUserKey(u);
        avo.setFkForumTypeKey(tf.getFkForumTypeKey());
        avo.setBrowseConut(tf.getBrowseConut());
        avo.setIsNull(tf.getIsNull());
        avo.setIsNullInt(tf.getIsNullInt());
        avo.setContentDescribe(tf.getContentDescribe());
        return avo;

    }

}
