package com.school.service.impl;

import com.school.entity.TForumComment;
import com.school.entity.TForumCommentExample;
import com.school.mapper.TForumCommentMapper;
import com.school.service.ForumCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 文章回复实现层
 */
@Service
public class ForumCommentServiceImpl implements ForumCommentService {
    @Autowired
    TForumCommentMapper fcm;
    ReadWriteLock rwl = new ReentrantReadWriteLock();

    //多线程对同一个方法的成员变量进行操作 是可以控制的
    //多线程同时访问多个方法 每个方法都使用过这个成员变量  控制数据共享 而且 执行效率快
    @Override
    public List<TForumComment> selectFkIdToComment(int id) {
        TForumCommentExample fce = new TForumCommentExample();
        fce.or()
                .andFkForumArticleKeyEqualTo(id);
        fce.setOrderByClause("create_time asc");
        List<TForumComment> lfc = fcm.selectByExample(fce);
        return lfc;

    }

    @Override
    public int addComment(TForumComment tForumComment) {
        int i = 0;
        if (tForumComment != null) {
           i  = fcm.addComment(tForumComment);
            if (i != 0) {
                return i;
            }
        }
        return i;
    }

    @Override
    public List<Integer> selectFindByUserIdComment(int id, int start, int end) {
        Map map = new HashMap();
        map.put("userId", id);
        map.put("start", start);
        map.put("end", end);
        System.out.println(id + " " + start + " " + end + " ");
        List<Integer> list = fcm.selectCommentByUserId(map);
        if (list != null && list.size() != 0) {
            return list;
        }
        return null;
    }

    @Override
    public List<Integer> selectNewsTimeComment(int id, int start, int end, String createTime) {
        Map map = new HashMap();
        map.put("userId", id);
        map.put("start", start);
        map.put("end", end);
        map.put("createTime", createTime);
        List<Integer> list = fcm.selectNewsTimeCommentByUserId(map);
        if (list != null && list.size() != 0) {
            return list;
        }
        return null;
    }
}
