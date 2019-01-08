package com.school.service.impl;

import com.school.entity.TSignup;
import com.school.entity.TSignupExample;
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
        TSignupExample signupExample = new TSignupExample();
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
}
