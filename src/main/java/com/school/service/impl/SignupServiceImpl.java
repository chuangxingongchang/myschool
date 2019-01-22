package com.school.service.impl;

import com.school.entity.*;
import com.school.mapper.TIncomeMapper;
import com.school.mapper.TPlurMapper;
import com.school.mapper.TSignupMapper;
import com.school.mapper.TUserMapper;
import com.school.service.SignupService;
import com.school.util.DateUtil;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private TSignupMapper tSignupMapper;
    @Autowired
    private TPlurMapper plurMapper;
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TIncomeMapper incomeMapper;

    @Override
    public List<Integer> selectPlurId(int plurid,String signstate) {
        TSignupExample signupExample = new TSignupExample();
        signupExample.or().andPkPluridEqualTo(plurid)
        .andSignstateEqualTo(signstate);
        List<TSignup> signupList = tSignupMapper.selectByExample(signupExample);
        List<Integer> integerList = new ArrayList<Integer>();
        for (TSignup t : signupList) {
            integerList.add(t.getPkUid());
        }
        return  integerList;
    }


    @Override
    public List<TSignup> selectSignup(int plurid, String signstate) {
        TSignupExample signupExample = new TSignupExample();
        signupExample.or().andPkPluridEqualTo(plurid)
                .andSignstateEqualTo(signstate);
        List<TSignup> signupList = tSignupMapper.selectByExample(signupExample);
        for (TSignup t : signupList) {
            if(t.getSignmoney()==null){
                t.setSignmoney(0.0);
            }
        }
        return signupList;
    }

    @Override
    public int selectBySignup(TSignup signup) {
        TSignupExample signupExample = new TSignupExample();
        signupExample.or().andPkPluridEqualTo(signup.getPkPlurid())
        .andPkUidEqualTo(signup.getPkUid());
        List<TSignup> signupList = tSignupMapper.selectByExample(signupExample);
        int id  = signupList.get(0).getId();
        return id;
    }

    @Override
    public boolean updateSignupState(int id) {
        TSignup signup = new TSignup();
        signup.setId(id);
        int b = tSignupMapper.updateByPrimaryKeySelective(signup);
        if (b>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateSigns(int id,List<String> list) {
        List<Integer> integerlist = new ArrayList<Integer>();
        for (String s : list) {
           integerlist.add(Integer.parseInt(s));
        }
        TSignupExample signupExample = new TSignupExample();
        TSignupExample signupExample1 = new TSignupExample();
        signupExample.or().andPkPluridEqualTo(id).andPkUidIn(integerlist);
        signupExample1.or().andPkPluridEqualTo(id).andPkUidNotIn(integerlist);
        TSignup signup = new TSignup();
        TPlur tPlur = new TPlur();
        tPlur.setFkWorkstate(2);
        tPlur.setId(id);
       int a = tSignupMapper.updateByExampleSelective(signup,signupExample);
       int c = plurMapper.updateByPrimaryKeySelective(tPlur);
       if (c>0&&a>0){
           try {
               int b = tSignupMapper.deleteByExample(signupExample1);
           }catch (Exception e){
               return true;
           }
           return true;
       }else {
           try {
               throw new Exception();
           } catch (Exception e) {
               return false;
           }
       }
    }

    @Override
    public boolean updateSigntoEnd(List<TSignup> signupList) {
        int plurid = signupList.get(0).getPkPlurid();
        TPlur plur = new TPlur();
        plur.setFkWorkstate(3);
        plur.setId(plurid);
        int a = plurMapper.updateByPrimaryKeySelective(plur);
        int c = 0;
        for (TSignup s : signupList) {
            TSignupExample signupExample = new TSignupExample();
            signupExample.or().andPkPluridEqualTo(plurid)
            .andPkUidEqualTo(s.getPkUid());
            TSignup signup = new TSignup();
            signup.setSignmoney(s.getSignmoney());
             c = tSignupMapper.updateByExampleSelective(signup,signupExample);
             if(c<=0){
                 try {
                     throw  new Exception();
                 } catch (Exception e) {
                     return false;
                 }
              }
            }
        if (a>0&&c>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Message updateMoney(int pkPlurid, double summoney) {
        Message ms = new Message();
        TPlur plur = plurMapper.selectByPrimaryKey(pkPlurid);
        TUser user = userMapper.selectByPrimaryKey(plur.getFkPublisher());
        if(summoney>user.getBalance()){
            ms.setMsg("您的余额不足，请充值");
            ms.setStatus(false);
        }else{
            if(user.getCredit()<=98){
                int credit = user.getCredit()+2;
                user.setCredit(credit);
            }
            double balance = user.getBalance()-summoney;
            user.setBalance(balance);
            int a = userMapper.updateByPrimaryKeySelective(user);
            if(a>0){
                TSignupExample signupExample = new TSignupExample();
                signupExample.or().andPkPluridEqualTo(pkPlurid);
                List<TSignup> signupList = tSignupMapper.selectByExample(signupExample);
                if(signupList.size()>0){
                    int b = 0;
                    for (TSignup s : signupList) {
                        TUser u = userMapper.selectByPrimaryKey(s.getPkUid());
                        double sumbalance = u.getBalance()+s.getSignmoney();
                        u.setBalance(sumbalance);
                        b = userMapper.updateByPrimaryKeySelective(u);
                        TIncome tIncome = new TIncome();
                        tIncome.setFkUid(s.getPkUid());
                        tIncome.setContent(plur.getWorkcontent());
                        String date = DateUtil.getDate(new Date());
                        tIncome.setMoneytime(date);
                        tIncome.setMoneys(s.getSignmoney());
                        int c = incomeMapper.insertSelective(tIncome);
                        if(b<0){
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                ms.setStatus(false);
                               ms.setMsg("系统异常...");
                               break;
                            }
                        }
                    }
                    TPlur plurs1= new TPlur();
                    plurs1.setId(pkPlurid);
                    plurs1.setFkWorkstate(4);
                    int c = plurMapper.updateByPrimaryKeySelective(plurs1);
                    if(c<=0){
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            ms.setStatus(false);
                            ms.setMsg("系统异常...");
                        }
                    }else{
                        ms.setStatus(true);
                    }
                }else{
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        ms.setStatus(false);
                        ms.setMsg("系统异常");
                    }
                }
            }else{
                try {
                    throw  new Exception();
                } catch (Exception e) {
                    ms.setStatus(false);
                    ms.setMsg("支付异常...");
                }
            }
        }
        return ms;
    }

    @Override
    public Message insertSignup(TSignup signup) {
        Message ms = new Message();
        TSignupExample signupExample = new TSignupExample();
        signupExample.or().andPkPluridEqualTo(signup.getPkPlurid())
                .andPkUidEqualTo(signup.getPkUid())
                .andSignstateEqualTo(signup.getSignstate());
            List<TSignup> signups = tSignupMapper.selectByExample(signupExample);
        if(signups!=null&&signups.size()>0) {
            ms.setStatus(false);
            ms.setMsg("该工作您已经报名了");
        }else{
            int a = tSignupMapper.insertSelective(signup);
            if (a > 0) {
                ms.setStatus(true);
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    ms.setMsg("报名失败");
                    ms.setStatus(false);
                    return ms;
                }
            }
        }
        return ms;
    }
}
