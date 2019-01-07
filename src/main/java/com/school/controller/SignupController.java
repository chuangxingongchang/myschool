package com.school.controller;

import com.school.entity.TUser;
import com.school.service.SignupService;
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
@RequestMapping("/sign")
public class SignupController {
    @Autowired
    private SignupService signupService;
    @Autowired
    private UserService userService;
    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    private Message ms   = new Message();

    @RequestMapping("/getSignupAll")
    public ModelAndView getsignUp(int pkPlurid,String signstate){
        List<Integer> integerList  = signupService.selectPlurId(pkPlurid,signstate);
        List<TUser>  userList  = new ArrayList<TUser>();
        if (integerList.size()>0){
            for (Integer i : integerList) {
                System.out.println(i);
                TUser user = userService.selectById(i);
                userList.add(user);
            }
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("signup",userList);
        mav.addObject("ms",ms);
        return  mav;
    }
}
