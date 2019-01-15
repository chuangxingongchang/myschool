package com.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.school.entity.TActivity;
import com.school.service.ActivityService;
import com.school.service.UserService;
import com.school.util.DateUtil;
import com.school.util.Message;
import com.school.vo.ActivityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    private UserService userService;

    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

    private Message ms = new Message();

    /**
     * @return 描述：获取所有活动的属性
     */
    @RequestMapping("/getallActivity")
    public ModelAndView dfd() {
        List<TActivity> activityList = activityService.selectAll();
        if (activityList.size() > 0) {
            ms.setStatus(true);
        } else {
            ms.setStatus(false);
        }
        mav.addObject("msg", ms);
        mav.addObject("activity", activityList);
        return mav;
    }

    /**
     * 获取活动创建时间排序
     */
    @RequestMapping("/getCreateTime")
    public ModelAndView timeSort() {
        List<TActivity> activityList = activityService.selectAllByTimeSort();
        if (activityList.size() > 0) {
            ms.setStatus(true);
        } else {
            ms.setStatus(false);
        }
        mav.addObject("msg", ms);
        mav.addObject("activity", activityList);
        return mav;
    }

    /**
     * 获取报名参加活动人数排序
     */
    @RequestMapping("/getnumber")
    public ModelAndView number() {
        List<TActivity> activityList = activityService.selectAllByNumberSort();
        if (activityList.size() > 0) {
            ms.setStatus(true);
        } else {
            ms.setStatus(false);
        }
        mav.addObject("msg", ms);
        mav.addObject("activity", activityList);
        return mav;
    }

    @RequestMapping("/getActivityById")
    @ResponseBody
    public Object activityById(int id) throws ParseException {
        JSONObject job=new JSONObject();
        TActivity activity = (TActivity) activityService.selectActivityById(id);
        if(activity!=null){
            job.put("obj",activity);
        }
        mav.addObject("obj",activity);
        return mav;
    }

    @RequestMapping("/addActivity")
    public ModelAndView addActivity(ActivityVo activityVo){
        TActivity activity = new TActivity();
        activity.setTitles(activityVo.getTitles());
        activity.setContent(activityVo.getContent());
        //毫秒转日期
        activity.setActivitytime(DateUtil.getDate(DateUtil.DateTimeTOString(activityVo.getActivitytime())));
        activity.setAddress(activityVo.getAddress());
        activity.setPrecautions(activityVo.getPrecautions());
        activity.setClaim(activityVo.getClaim());
        activity.setObjects(activityVo.getObjects());
        activity.setOrganizer(activityVo.getOrganizer());
        activity.setFkUserid(activityVo.getFkUserid());
        activity.setCreatetime(DateUtil.getLongDate(DateUtil.DateTimeTOLongString(activityVo.getCreatetime())));
        boolean flag = activityService.addActivity(activity);
        if(flag){
            ms.setStatus(true);
        }else {
            ms.setStatus(false);
        }
        mav.addObject("ms",ms);
        return mav;
    }

}
