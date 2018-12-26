package com.school.controller;

import com.school.entity.TPlur;
import com.school.entity.TSchool;
import com.school.entity.TUser;
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
    @RequestMapping("/selectPlurall")
    public void selectPlurAll(){
        List<TPlur> plurList = plurService.selectAllTplur();
        for(TPlur tP:plurList){
            System.out.println(tP);
        }
    }
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
}
