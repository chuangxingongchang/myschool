package com.school.service;

import com.school.entity.TUser;

public interface UserService {

    boolean insertUser(TUser user);
    boolean login(TUser user);
    boolean forgetPword(String phoneno,String pword);
    boolean addMoney(TUser user);
    boolean updateUser(TUser user);
    TUser  selectByPhoneno(String phoneno);
}
