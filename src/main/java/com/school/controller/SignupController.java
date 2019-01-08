package com.school.controller;

import com.school.entity.TSignup;
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

    /**
     * @param pkPlurid
     * @param signstate
     * @return
     * 描述：获取所有的兼职报名者信息
     */
    @RequestMapping("/getSignupAll")
    public ModelAndView getsignUp(int pkPlurid,String signstate){
        System.out.println("pkPlurid:"+pkPlurid);
        System.out.println("signstate:"+signstate);
        List<Integer> integerList  = signupService.selectPlurId(pkPlurid,signstate);
        List<TUser>  userList  = new ArrayList<TUser>();
        if (integerList.size()>0){
            for (Integer i : integerList) {
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
    @RequestMapping("/updateSignstate")
    public ModelAndView updatesignState(TSignup signup){
        System.out.println("更新signstate"+signup.getPkUid()+"plur"+signup.getPkPlurid());
        int s  = signupService.selectBySignup(signup);
        boolean flag = signupService.updateSignupState(s);
        if (flag){
            ms.setStatus(true);
        }else {
            ms.setStatus(false);
        }
        mav.addObject("mss",ms);
        return mav;
    }
}
