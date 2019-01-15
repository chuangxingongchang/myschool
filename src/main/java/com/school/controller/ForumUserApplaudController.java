package com.school.controller;

import com.school.service.ForumUserApplaudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/28.
 * 用户点赞controller
 */
@RequestMapping("/applaud")
@RestController
public class ForumUserApplaudController {
    @Autowired
    ForumUserApplaudService service;
    boolean b = false;

    /**
     * 添加点赞
     * @param userId 谁
     * @param articleId 给哪篇文章点赞
     *
     */
    @RequestMapping("/add")
    public boolean addApplaud(int userId, int articleId){
        b = service.addApplaud(userId,articleId);
        return b;
    }

    /**
     * 删除点赞
     * @param userId 谁
     * @param articleId 删除哪篇文章的点赞
     * @return
     */
    @RequestMapping("/delete")
    public boolean deleteApplaud(int userId, int articleId){
        b = service.deleteApplaud(userId,articleId);
        return b;
    }

    /**
     * 判断是否点过赞
     * @param userId 谁
     * @param articleId 哪篇文章
     * @return
     */
    @RequestMapping("/boolean")
    public boolean selectMeWhetherApplaud(int userId, int articleId){
        b = service.selectMeWhetherApplaud(userId,articleId);
        return b;
    }
}
