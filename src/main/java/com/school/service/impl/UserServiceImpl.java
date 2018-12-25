package com.school.service.impl;

import com.school.entity.TUser;
import com.school.entity.TUserExample;
import com.school.mapper.TUserMapper;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;
    private TUserExample tUserExample;

    /**
     * 注册
     * @param user
     * @return boolean
     */
    @Override
    public boolean insertUser(TUser user) {
        if(userMapper.insert(user)>0){
            return true;
        }
        return false;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public boolean login(TUser user) {

        tUserExample.or()
                .andPhonenoEqualTo(user.getPhoneno())
                .andPwordEqualTo(user.getPword());
        if(userMapper.selectByExample(tUserExample).size()>0){
            tUserExample.clear();
            return true;
        }
        tUserExample.clear();
        return false;
    }


    @Override
    public boolean forgetPword(TUser user,TUserExample userExamples) {
        if(userMapper.updateByExampleSelective(user,userExamples)>0){
            return true;
        }
        return  false;
    }

    @Override
    public boolean addMoney(TUser user) {
        if (userMapper.updateByPrimaryKey(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(TUser user, TUserExample tUserExample) {
       if(userMapper.updateByExampleSelective(user,tUserExample)>0){
           return true;
       }
       return false;
    }
}
