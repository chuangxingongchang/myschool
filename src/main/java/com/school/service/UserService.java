package com.school.service;

import com.school.entity.TUser;

import java.util.List;

public interface UserService {
    List<TUser> selectAllUser();
    boolean insertUser(TUser user);
    boolean login(TUser user);
    boolean forgetPword(String phoneno,String pword);
    boolean addMoney(TUser user);
    boolean updateUser(TUser user);
    TUser  selectByPhoneno(String phoneno);
    TUser  selectById(int id);
    /**
     *  通过Id获取IN（包含的User对象
     * @param  id
     * @return List User
     */
    List<TUser> selectUserIdIn(List<Integer> id);

    /**
     * 通过ID获取userNickname
     * author: laip
     */
    TUser selectNicknameById(int uid);
}
