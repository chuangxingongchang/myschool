package com.school.controller;

import com.school.entity.TSignup;
import com.school.entity.TUser;
import com.school.service.SignupService;
import com.school.service.UserService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    /**
     * @param pkPlurid
     * @param list
     * @return
     * 描述：报名确认，修改plur和signup表兼职状态为"进行"，并把没有报名成功的用户删除
     */
    @RequestMapping("/updateSigns")
    public  ModelAndView updatesigntoGo(int pkPlurid,@RequestParam("list[]") List<String> list){
        boolean flag = signupService.updateSigns(pkPlurid,list);
        if(flag){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("mss",ms);
        return mav;
    }

    /**
     * @param signList
     * @return
     * 描述：发布者确认完成兼职后，更新plur和signup状态为“完成”,并修改他的工资
     */
    @RequestMapping("/updateGotoEnd")
    public  ModelAndView updatesigntoEnd(@RequestBody List<TSignup> signList){
        boolean flag = signupService.updateSigntoEnd(signList);
        if(true){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("mes",ms);
        return mav;
    }
    /**
     * @param pkPlurid
     * @param signstate
     * @return
     *描述:根据当前兼职id 和状态得到所有完成人员的信息 并计算他们的总值
     */
    @RequestMapping("/signupEnd")
    public ModelAndView getsignUpEnd(int pkPlurid,String signstate){
        List<Integer> integerList  = signupService.selectPlurId(pkPlurid,signstate);
        List<TUser>  userList  = new ArrayList<TUser>();
        List<TSignup> signupList = signupService.selectSignup(pkPlurid,signstate);
        if (integerList.size()>0) {
            for (Integer i : integerList) {
                TUser user = userService.selectById(i);
                userList.add(user);
            }
        }
        double sumMoney = 0.0;
        for (TSignup t : signupList) {
            sumMoney += t.getSignmoney();
        }
        ms.setData(sumMoney);
        mav.addObject("mm",ms);
        mav.addObject("enduser",userList);
        mav.addObject("endMoney",signupList);
        return mav;
    }

    /**
     * @param pkPlurid
     * @param summoney
     * @return
     * 描述:根据提供的兼职id和总支付的钱，更新TSignup、TPlur、TUser的金额，
     * 支付成功删除该条兼职的TSignup\TPlur的记录
     */
    @RequestMapping("/updateUserMoney")
    public ModelAndView topayMoney(int pkPlurid,double summoney){
        ms = signupService.updateMoney(pkPlurid,summoney);
        mav.addObject("upMoney",ms);
        System.out.println("执行成功与否？"+ms.isStatus());
        return  mav;
    }

    /**
     * @param signup
     * @return
     * 描述:用户对兼职进行报名，并把信息放入TSignup,
     * 发布者查看当前报名者信息，以便发布者确认
     */
    @RequestMapping("/startSignup")
    public ModelAndView comeSignup(TSignup signup){
        ms = signupService.insertSignup(signup);
        mav.addObject("startms",ms);
        return mav;
    }
}
