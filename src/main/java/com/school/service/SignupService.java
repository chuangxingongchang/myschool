package com.school.service;

import com.school.entity.TSignup;

import java.util.List;

public interface SignupService {
    List<Integer> selectPlurId(int plurid,String signstate);
    int selectBySignup(TSignup signup);
    boolean updateSignupState(int id);
    boolean updateSigns(int id,List<String> list);
    boolean updateSigntoEnd(List<TSignup> signupList);
}
