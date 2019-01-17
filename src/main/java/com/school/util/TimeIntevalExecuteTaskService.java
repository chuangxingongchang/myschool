package com.school.util;

import com.school.entity.TForumArticle;
import com.school.entity.TForumType;
import com.school.service.ForumArticleService;
import com.school.service.ForumTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时执行任务
 */
@Controller
@Transactional
public class TimeIntevalExecuteTaskService {
    @Autowired
    ForumArticleService forumArticleService;
    @Autowired
    ForumTypeService forumTypeService;
    static List<TForumArticle> listArticle = new ArrayList<>();

    public boolean addPushArticle(){
        boolean b = false;
        //获取 其他类型
        List<TForumType> tForumTypes = forumTypeService.selectForumTypeOption();
        List<Integer> type_id = new ArrayList<>();
        for (TForumType tForumType : tForumTypes) {
            type_id.add(tForumType.getId());
            System.out.println(tForumType.toString());
        }
        //获取每个类型的最热门的10 条 数据
        for (Integer integer : type_id) {
             listArticle.addAll(forumArticleService.selectTypeLimitOrderDescBro(integer));
        }
        b = forumArticleService.addListArticle(listArticle);
         return b;
    }
}
