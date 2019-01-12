package com.school.service;

import com.school.entity.TSignup;
import com.school.util.Message;

import java.util.List;

public interface SignupService {
    //查询该兼职plurid，以signstate状态执行的所有用户id
    List<Integer> selectPlurId(int plurid,String signstate);
    //查询该兼职当前状态的所有TSignup
    List<TSignup> selectSignup(int plurid,String signstate);

    int selectBySignup(TSignup signup);
    boolean updateSignupState(int id);
    //更新当前id的兼职的信息
    boolean updateSigns(int id,List<String> list);
    //兼职进行->完成，状态更新
    boolean updateSigntoEnd(List<TSignup> signupList);
    //兼职完成，更新TSignup 、TUser、TPlur
    Message updateMoney(int pkPlurid, double summoney);
    //新增用户对兼职报名
    Message insertSignup(TSignup signup);
}
