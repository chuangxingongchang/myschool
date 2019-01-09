package com.school.service.impl;

import com.school.entity.TPlur;
import com.school.entity.TSignup;
import com.school.entity.TSignupExample;
import com.school.mapper.TPlurMapper;
import com.school.mapper.TSignupMapper;
import com.school.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    private TSignupMapper tSignupMapper;
    @Autowired
    private TPlurMapper plurMapper;

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
        signup.setSignstate("进行");
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
        signup.setSignstate("进行");
        TPlur tPlur = new TPlur();
        tPlur.setFkWorkstate(2);
        tPlur.setId(id);
       int a = tSignupMapper.updateByExampleSelective(signup,signupExample);
        System.out.println("a:"+a);
       int b = tSignupMapper.deleteByExample(signupExample1);
        System.out.println("b:"+b);
       int c = plurMapper.updateByPrimaryKeySelective(tPlur);
        System.out.println("c:"+c);
       if (b>0&&c>0&&a>0){
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
            signup.setSignstate("完成");
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
}
