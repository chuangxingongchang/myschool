package com.school.controller;

import com.school.entity.*;
import com.school.service.PlurService;
import com.school.service.UserService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plur")
public class PlurController {
    @Autowired
    private PlurService plurService;
    @Autowired
    private UserService userService;

    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

    private Message ms = new Message();

    /**
     * @param fkSchoolId
     * @return
     * 描述：查询当前学校所有兼职
     */

    @RequestMapping("/selectPlurSchool")
    public ModelAndView selectPlurBySchool(int fkSchoolId) {
        List<TPlur> plurList = null;
        List<TWorkicon> workiconList = null;
        List<TUnit> unitList = null;
        try {
            plurList = plurService.selectBySchool(fkSchoolId);
            workiconList = plurService.selectAllWorkicon();
            unitList = plurService.selectAllUnit();
            ms.setStatus(true);
            if (plurList.size() > 0) {
                ms.setMsg("加载中...");
            } else {
                ms.setMsg("该学校无兼职，等待发布中");
            }
        } catch (Exception e) {
            ms.setMsg("系统出现错误...");
            ms.setStatus(false);
        } finally {
            mav.addObject("ms", ms);
            mav.addObject("plur", plurList);
            mav.addObject("workicon", workiconList);
            mav.addObject("unit", unitList);
            return mav;
        }
    }

    /**
     * @param id
     * @param fkPublisher
     * @return
     * 描述：根据兼职thisid和用户fkPublisher查询详细信息
     */

    @RequestMapping("/getThisPlur")
    public ModelAndView getThisPlurs(int id,int fkPublisher){
        List<TUnit> unitList = plurService.selectAllUnit();
        TUser user = userService.selectById(fkPublisher);
        mav.addObject("unit",unitList);
        mav.addObject("thisplur",plurService.selectByTplurId(id));
        mav.addObject("pushuser",user);
        return mav;
    }

    /**
     * @param id
     * @return
     * 描述:根据登录用户id查询用户所有兼职
     */
    @RequestMapping("/myPlur")
    public ModelAndView selectMyPlur(int id) {
        List<TPlur> plurList = plurService.selectByUser(id);
        List<TPlur> goplurList = new ArrayList<TPlur>();
        List<TPlur> endplurList = new ArrayList<TPlur>();
        List<TWorkicon> workiconList = plurService.selectAllWorkicon();
        for(TPlur p:plurList){
            if(p.getFkWorkstate()==2){
                goplurList.add(p);
            }else if(p.getFkWorkstate()==3){
                endplurList.add(p);
            }
        }
        mav.addObject("workicon",workiconList);
        mav.addObject("goplur",goplurList);
        mav.addObject("endplur",endplurList);
        return  mav;
    }
}
