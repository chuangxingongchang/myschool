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
}
