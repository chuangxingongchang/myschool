package com.school.controller;

import com.school.entity.TActivityUser;
import com.school.service.ActivityUserService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@RestController
@RequestMapping("/activityuser")
public class ActivityUserController {
    @Autowired
    private ActivityUserService activityUserService;
    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    private Message ms = new Message();

    @RequestMapping("/getInterById")
    public ModelAndView selectByAcId(Integer acId) {
        if (acId != 0) {
            List<TActivityUser> activityUserList = activityUserService.selectByAcId(acId);
            if (activityUserList.size()>0) {
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
            }
            mav.addObject("ms", ms);
            mav.addObject("activityUserList", activityUserList);
        }
        return mav;
    }

    @RequestMapping("/insertActvtUser")
    public ModelAndView insertActvtUser(int userId, int acId){
        TActivityUser activityUser = new TActivityUser();
        activityUser.setUserId(userId);
        activityUser.setAcId(acId);
        boolean flag = activityUserService.insertActvtUser(activityUser);
        if(flag){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("ms",ms);
        return mav;
    }

    @RequestMapping("/selectActivityUsers")
    public ModelAndView selectActivityUsers(Integer acId){
        List<TActivityUser> activityUserList = activityUserService.selectActivityUsers(acId);
        if(activityUserList.size()>0){
            ms.setStatus(true);
        }else {
            ms.setStatus(false);
        }
        mav.addObject("ms",ms);
        mav.addObject("acUsers",activityUserList);
        return mav;
    }

    /**
     * @param a
     * @return
     * 验证报名:已报名返回false，没报名返回，进行报名 返回true
     */
    @RequestMapping("/intoSignupAc")
    public ModelAndView insertAcSignup(TActivityUser a){
        boolean flag = activityUserService.insertActvtUser(a);
        ms.setStatus(flag);
        mav.addObject("inms",ms);
        return mav;
    }
}
