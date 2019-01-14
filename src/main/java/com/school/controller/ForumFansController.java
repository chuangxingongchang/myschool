package com.school.controller;

import com.school.entity.TForumFans;
import com.school.entity.TUser;
import com.school.service.ForumFansService;
import com.school.service.ForumMindService;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/24
 * @Field:
 */
@RequestMapping("/fans")
@RestController
public class ForumFansController {

    @Autowired
    ForumFansService forumFansService;
    @Autowired
    ForumMindService forumMindService;
    @Autowired
    UserService userService;

    /**
     * 根据_id 查询粉丝
     *
     * @param userId 用户的ID
     * @return
     */
    @RequestMapping("/fansUser")
    public ModelAndView selectMeFansUser(Integer userId, Integer start, Integer end) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        if (userId != null && start != null && end != null) {
            List<TForumFans> fansList = forumFansService.selectMeFansUser(userId, start, end);
            if (fansList != null) {
                List<Integer> list = new ArrayList<>();
                for (TForumFans tForumFans : fansList) {
                    list.add(tForumFans.getFkFansUser());
                }
                List<TUser> users = userService.selectUserIdIn(list);
                modelAndView.addObject("fansUserList", users);
            }
        }
        return modelAndView;
    }

    /**
     * 删除粉丝
     *
     * @param userId 主动关注的人 成为粉丝
     * @param deid   被动人
     * @return
     */
    @RequestMapping("/deleteFans")
    public boolean deleteFans(int userId, int deid) {
        boolean b = false;
        b = forumFansService.deleteFans(userId, deid);
        b = forumMindService.deleteMind(userId, deid);
        return b;

    }

}
