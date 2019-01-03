package com.school.controller;

import com.school.entity.TSchool;
import com.school.entity.TUser;
import com.school.service.SchoolService;
import com.school.service.UserService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private UserService userService;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping("updateMyschool")
    public ModelAndView updateSchool(String schoolname,String schoolcity, TUser user) {
        TSchool school = new TSchool();
        school.setSchoolcity(schoolcity);
        school.setSchoolname(schoolname);
        System.out.println("school:"+school);
        System.out.println("school:"+user);
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        Message ms = new Message();
        try {
            System.out.println("进入直接修改");
            boolean flag1 = schoolService.checkThisSchool(school);
            System.out.println(flag1);
            if (flag1) {
                Integer fkSchoolId = schoolService.selectBySchoolname(school.getSchoolname());
                System.out.println("fkSchoolId:"+fkSchoolId);
                user.setFkSchoolId(fkSchoolId);
                boolean flag = userService.updateUser(user);
                if (flag) {
                    ms.setStatus(true);
                    ms.setMsg("你已经完成了对学校的修改");
                } else {
                    ms.setStatus(false);
                    ms.setMsg("修改失败");
                }
            } else {
                System.out.println("进入新增");
                boolean flag2 = schoolService.insertSchool(school);
                System.out.println(flag2);
                if (flag2) {
                    Integer fkSchoolId = schoolService.selectBySchoolname(school.getSchoolname());
                    System.out.println("fkSchoolId:"+fkSchoolId);
                    user.setFkSchoolId(fkSchoolId);
                    boolean flag = userService.updateUser(user);
                    if (flag) {
                        ms.setStatus(true);
                        ms.setMsg("你已经完成了对学校的修改");
                    } else {
                        ms.setStatus(false);
                        ms.setMsg("修改失败");
                    }
                }
            }
        } catch (Exception e) {
            ms.setStatus(false);
            ms.setMsg("没有该学校");
        } finally {
            mav.addObject("ms", ms);
            return mav;
        }
    }
    @RequestMapping("/getSchool")
    public ModelAndView getMySchool(int fkSchoolId){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        String schoolname = schoolService.selectByFkSchoolId(fkSchoolId);
        mav.addObject("schoolname",schoolname);
        return mav;
    }
}
