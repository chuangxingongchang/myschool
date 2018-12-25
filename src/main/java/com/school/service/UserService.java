package com.school.service;

import com.school.entity.TUser;
import com.school.entity.TUserExample;

public interface UserService {

    boolean insertUser(TUser user);
    boolean login(TUser user);
    boolean forgetPword(TUser user, TUserExample tUserExamples);
    boolean addMoney(TUser user);
    boolean updateUser(TUser user,TUserExample tUserExample);
}
