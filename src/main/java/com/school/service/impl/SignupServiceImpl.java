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

    private TSignupExample signupExample = new TSignupExample();
    @Override
    public List<Integer> selectPlurId(int plurid,String signstate) {
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
    public boolean updateSignupState(TSignup signup) {
        TSignup signup1 = new TSignup();
        signup1.setSignstate("进行");
        TSignupExample.Criteria criteria =  signupExample.createCriteria();
        TSignupExample.Criteria criteria1 =  signupExample.createCriteria();
        criteria
                .andPkPluridEqualTo(3);
        criteria1
                .andPkUidEqualTo(9);
        signupExample.or(criteria1);
        signupExample.or(criteria);
        int b = tSignupMapper.updateByExampleSelective(signup1,signupExample);
        if (b>0){
            return true;
        }else {
            return false;
        }
    }
}
