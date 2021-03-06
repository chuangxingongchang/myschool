package com.school.controller;

import com.school.entity.*;
import com.school.service.JobAllUnitService;
import com.school.service.PlurService;
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
@RequestMapping("/plur")
public class PlurController {
    @Autowired
    private PlurService plurService;
    @Autowired
    private UserService userService;
    @Autowired
    private JobAllUnitService jobAllUnitService;
    @Autowired
    private SignupService signupService;

    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

    private Message ms = new Message();

    /**
     * @param fkSchoolId
     * @return
     * 描述：查询当前学校所有兼职
     */

    @RequestMapping("/selectPlurSchool")
    public ModelAndView selectPlurBySchool(int fkSchoolId) {
        System.out.println("进入学校兼职查询");
        List<TPlur> plurList = null;
        List<TUnit> unitList = null;
        List<TSettle> settleList = jobAllUnitService.selectAllSettle();
        try {
            plurList = plurService.selectBySchool(fkSchoolId);
            unitList = plurService.selectAllUnit();
            ms.setStatus(true);
            if (plurList.size() > 0) {
                ms.setMsg("加载中...");
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
                ms.setMsg("该学校无兼职，等待发布中");
            }
        } catch (Exception e) {
            ms.setMsg("系统出现错误...");
            ms.setStatus(false);
        } finally {
            mav.addObject("ms", ms);
            mav.addObject("settl",settleList);
            mav.addObject("plur", plurList);
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
        TPlur plur = plurService.selectByTplurId(id);
        List<TSettle> settleLsit = jobAllUnitService.selectAllSettle();
        int count = plur.getCounts();
        count++;
        boolean flag = plurService.updateCounts(plur.getId(),count);
        if(flag==true){
            ms.setStatus(true);
        }else {
            ms.setStatus(false);
        }
        plur.setCounts(count);
        mav.addObject("ms",ms);
        mav.addObject("settle",settleLsit);
        mav.addObject("unit",unitList);
        mav.addObject("thisplur",plur);
        mav.addObject("pushuser",user);
        return mav;
    }

    /**
     * @param id
     * @return
     * 获取当前进行的兼职的详细信息及用户信息
     */
    @RequestMapping("/getGothisplur")
    public ModelAndView getGoplur(int id){
        String signstate = "进行";
        List<TUnit> unitList = plurService.selectAllUnit();
        TPlur plur = plurService.selectByTplurId(id);
        List<TSettle> settleLsit = jobAllUnitService.selectAllSettle();
        List<Integer> integerList  = signupService.selectPlurId(id,signstate);
        List<TUser>  userList  = new ArrayList<TUser>();
            for (Integer i : integerList) {
                TUser user = userService.selectById(i);
                userList.add(user);
        }
        mav.addObject("settle",settleLsit);
        mav.addObject("unit",unitList);
        mav.addObject("thisplur",plur);
        mav.addObject("usergo",userList);
        return mav;
    }
    /**
     * @param id
     * @return
     * 描述:根据登录用户id查询用户所有兼职
     */
    @RequestMapping("/myPlur")
    public ModelAndView selectMyPlur(int id) {
        List<TPlur> plurList = plurService.selectByAccept(id);
        List<TPlur> goplurList  = new ArrayList<TPlur>();
        List<TPlur> endplurList = new ArrayList<TPlur>();
        Message ms2 = new Message();
        List<TUnit> workiconList = plurService.selectAllUnit();
        for(TPlur p:plurList){
            if(p!=null){
                if(p.getFkWorkstate()==2){
                    goplurList.add(p);
                }else if(p.getFkWorkstate()==3||p.getFkWorkstate()==4){
                    endplurList.add(p);
                }
            }
        }
        if(goplurList.size()>0){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        if(endplurList.size()>0){
            ms2.setStatus(true);
        }else{
            ms2.setStatus(false);
        }
        mav.addObject("ms",ms);
        mav.addObject("ms2",ms2);
        mav.addObject("workicon",workiconList);
        mav.addObject("goplur",goplurList);
        mav.addObject("endplur",endplurList);
        return  mav;
    }

    /**
     * @param fkPublisher
     * @return
     * 根据发布者id 获取发布者发布的兼职
     */
    @RequestMapping("/publisher")
    public ModelAndView getPublisherPlur(int fkPublisher){
        List<TPlur> publisherList = plurService.selectByPublisher(fkPublisher);
        List<TUnit> unitList = plurService.selectAllUnit();
        List<TPlur> newPulisherList = new ArrayList<TPlur>();
        List<TPlur> goPulisherList = new ArrayList<TPlur>();
        List<TPlur> endPulisherList = new ArrayList<TPlur>();
        for(TPlur p:publisherList){
            if(p.getFkWorkstate()==1){
                newPulisherList.add(p);
            }else if (p.getFkWorkstate()==2){
                goPulisherList.add(p);
            }else{
                endPulisherList.add(p);
            }
        }
        if (newPulisherList.size()>0){
            ms.setStatus(true);
        }else {
            ms.setStatus(false);
        }
        Message ms1 = new Message();
        if (goPulisherList.size()>0){
            ms1.setStatus(true);
        }else {
            ms1.setStatus(false);
        }
        Message ms2 = new Message();
        if (endPulisherList.size()>0){
            ms2.setStatus(true);
        }else {
            ms2.setStatus(false);
        }
        mav.addObject("ms",ms);
        mav.addObject("ms1",ms1);
        mav.addObject("ms2",ms2);
        mav.addObject("publisher",newPulisherList);
        mav.addObject("gopublisher",goPulisherList);
        mav.addObject("endpublisher",endPulisherList);
        mav.addObject("unit",unitList);
        return mav;
    }

    /**
     * @param plur
     * @return
     * 新发布的兼职
     */
    @RequestMapping("/insertPlur")
    public ModelAndView insertplur(TPlur plur){
        boolean flag = plurService.insertPlur(plur);
        if(flag==true){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("ms",ms);
        return mav;
    }

    /**
     * @param fkSchool
     * @param fkTimetype
     * @return
     * 根据时间类型和学校查询短期或长期兼职
     */
    @RequestMapping("/SLjob")
    public ModelAndView selectBySLPlur(int fkSchool,int fkTimetype){
        System.out.println("进入短长期兼职");
        List<TPlur> tPlurList = plurService.selectPlurBySL(fkSchool,fkTimetype);
        List<TUnit> unitList = plurService.selectAllUnit();
        if(tPlurList.size()>0){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("mssl",ms);
        mav.addObject("unit",unitList);
        mav.addObject("slList",tPlurList);
        return mav;
    }

    /**
     * @param fkSchoolId
     * @return
     * 根据信用度执行查询学校的兼职
     */
    @RequestMapping("selectPlurSchoolBycredit")
    public ModelAndView getplurByCreditDesc(int fkSchoolId){
        System.out.println("根据信用度排序。。。。");
        List<TUnit> unitList2 = plurService.selectAllUnit();
        List<SchoolCreditPlur> creditPlurList = plurService.selectBySchoolCredit(fkSchoolId);
        if(creditPlurList!=null&&creditPlurList.size()>0) {
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("unitcr",unitList2);
        mav.addObject("creditms",ms);
        mav.addObject("cre",creditPlurList);
        return mav;
    }
    /**
     * @param fkSchoolId
     * @return
     * 根据访问次数执行查询学校的兼职
     */
    @RequestMapping("/selectPlurSchoolByCount")
    public ModelAndView selectplurByCount(int fkSchoolId){
        System.out.println("根据访问次数排序。。。。");
        List<TUnit> unitList1 = plurService.selectAllUnit();
        List<TPlur> plurlist = plurService.selectBySchoolCount(fkSchoolId);
        if(plurlist!=null&&plurlist.size()>0){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("unitco",unitList1);
        mav.addObject("counms",ms);
        mav.addObject("cou",plurlist);
        return mav;
    }

    /**
     * @param schoolname
     * @return
     * 根据学校名，并且按访问次数和发布时间查询当前发布兼职
     */
    @RequestMapping("/plurByaccountAndtimeDesc")
    public ModelAndView selectByaccountAndtimeDesc(String schoolname){
        List<TPlur> plurList  = plurService.selectByaccountAndtimeDesc(schoolname);
        List<TUnit> unitLists = plurService.selectAllUnit();
        if(plurList!=null&&plurList.size()>0){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }

        mav.addObject("atunit",unitLists);
        mav.addObject("atms",ms);
        mav.addObject("atplur",plurList);
        return mav;
    }
    /**
     *
     */
    @RequestMapping("/jobsearch")
    public ModelAndView getJobBySearch(String searchname,String schoolname){
        List<TPlur> plurListse  = plurService.selectPlurBytoSearch(searchname,schoolname);
        List<TUnit> unitListse = plurService.selectAllUnit();
        if(plurListse!=null&&plurListse.size()>0){
            ms.setStatus(true);
        }else{
            ms.setStatus(false);
        }
        mav.addObject("unse",unitListse);
        mav.addObject("sems",ms);
        mav.addObject("selist",plurListse);
        return mav;
    }
    @RequestMapping("/delthisPlur")
    public ModelAndView delThisplur(int id){
        Message delms = plurService.deletePlurById(id);
        mav.addObject("delms",delms);
        return mav;
    }
}
