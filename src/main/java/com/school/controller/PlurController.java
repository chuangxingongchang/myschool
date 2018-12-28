package com.school.controller;

import com.school.entity.*;
import com.school.service.PlurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@RestController
public class PlurController {
    @Autowired
    private PlurService  plurService;
    @RequestMapping("/uu")
    public ModelAndView FJSD(){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        return mav;
    }

    /**
     * 查询所有兼职
     */
    @RequestMapping("/selectPlurall")
    public void selectPlurAll(){
        List<TPlur> plurList = plurService.selectAllTplur();
        for(TPlur tP:plurList){
            System.out.println(tP);
        }
    }
    /**
     * 根据当前用户学校查询所有兼职
     */
    @RequestMapping("/selectSchool")
    public ModelAndView selectBySchool(TSchool tSchool){
        try {
            System.out.println(tSchool);
            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
            List<TPlur> plurList = plurService.selectBySchool(tSchool);
            for(TPlur tP:plurList){
                System.out.println(tP);
            }
            mav.addObject(plurList);
            return  mav;

        }catch (Exception e){
            System.out.println("发生异常");
            return null;
        }

    }
    /**
     * 根据用户id查询所有兼职
     */
    @RequestMapping("/myPlur")
    public ModelAndView selectMyPlur(TUser tUser){
        try {
            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
            List<TPlur> plurList = plurService.selectByUser(tUser);
            mav.addObject(plurList);
            return mav;
        }catch (Exception e){
            System.out.println("发生异常");
            return null;
        }
  }
    /**
     * 根据位置属性查询所有兼职
     */
    @RequestMapping("myLocation")
    public ModelAndView selectByLocations(TLocation location){
        try {
            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
            List<TPlur> plurList = plurService.selectByLocation(location);
            mav.addObject(plurList);
            return mav;
        }catch (Exception e){
            System.out.println("发生异常");
            return null;
        }
    }
    /**
     * 根据岗位属性进行查询
     */
    @RequestMapping("myWorkType")
    public ModelAndView selectByWorkTypes(TWorktype worktype){
        try {
            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
            List<TPlur> plurList = plurService.selectByWorkType(worktype);
            mav.addObject(plurList);
            return mav;
        }catch (Exception e){
            System.out.println("发生异常");
            return null;
        }
    }
    /**
     * 根据时间属性来进行查询
     */
    @RequestMapping("myTimeType")
    public ModelAndView selectByTimeTypes(TTime times){
        try {
            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
            List<TPlur> plurList = plurService.selectByTime(times);
            mav.addObject(plurList);
            return mav;
        }catch (Exception e){
            System.out.println("发生异常");
            return null;
        }
    }
    /**
     * 根据结算属性进行查询
     */
    @RequestMapping("/myUnit")
    public ModelAndView selectByUnit(TUnit unit){
        try {
            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
            List<TPlur> plurList = plurService.selectByUnit(unit);
            mav.addObject(plurList);
            return mav;
        }catch (Exception e){
            System.out.println("发生异常");
            return null;
        }
    }
    /**
     *获取兼职图标
     */
    public void myicon(TPlur plur){
        TWorkicon icons = plurService.selectByTplur(plur);
    }
}
