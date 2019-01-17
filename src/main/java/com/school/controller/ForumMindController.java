package com.school.controller;

import com.school.entity.TForumFans;
import com.school.entity.TForumMind;
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
 * @Date: 2018/12/23
 * @Field:添加关注的人
 */
@RequestMapping("/mind")
@RestController
public class ForumMindController {
    @Autowired
    ForumMindService mindService;
    @Autowired
    ForumFansService fansService;
    @Autowired
    UserService userService;

    /**
     * 添加关注
     *
     * @param mindUserId
     * @param decideUserId
     * @return
     */
    @RequestMapping("/addMind")
    public boolean addMind(Integer mindUserId, Integer decideUserId) {
        boolean b = false;
        if (mindUserId != null && decideUserId != null){
            b = mindService.selectMeTrueFalseMindHe(mindUserId, decideUserId);
            if (!b) {
                TForumMind tForumMind = new TForumMind();
                tForumMind.setFkDecideUser(decideUserId);
                tForumMind.setFkMindUser(mindUserId);
                mindService.insertMeMindPerson(tForumMind);
                fansService.selectMeTrueFalseFans(mindUserId, decideUserId);
                b = fansService.addFans(mindUserId, decideUserId);
            }
        }
        return b;
    }

    @RequestMapping("/mindCount")
    public ModelAndView selectMeMindUserCount(int userId) {
        Long l = mindService.selectCountMindUser(userId);
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        modelAndView.addObject("mindCount", l);
        return modelAndView;
    }

    /**
     * 根据_id 查询关注的人
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/mindUser")
    public ModelAndView selectMeMindUser(Integer userId, Integer start, Integer end) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        if (userId != null && start != null && end != null) {
            List<TForumMind> forumMindList = mindService.selectMeMindUser(userId, start, end);
            if (forumMindList != null) {
                List<Integer> list = new ArrayList<>();
                for (TForumMind tForumMind : forumMindList) {
                    list.add(tForumMind.getFkDecideUser());
                }
                List<TUser> mindUserList = userService.selectUserIdIn(list);
                modelAndView.addObject("mindUserList", mindUserList);
            }
        }
        return modelAndView;
    }

    /**
     * 判断用户是否关注过谁
     *
     * @param userId 主动关注人
     * @param deId   被动人
     * @return
     */
    @RequestMapping("/booleanMind")
    public boolean selectMeTrueFalseMindHe(int userId, int deId) {
        return mindService.selectMeTrueFalseMindHe(userId, deId);
    }

}
