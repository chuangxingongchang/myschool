package com.school.service.impl;

import com.school.entity.TUser;
import com.school.entity.TUserExample;
import com.school.mapper.TUserMapper;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return boolean
     */
    @Override
    public boolean insertUser(TUser user) {
        int count = userMapper.insert(user);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public boolean login(TUser user) {
        TUserExample tUserExample = new TUserExample();
        tUserExample.or()
                .andPhonenoEqualTo(user.getPhoneno())
                .andPwordEqualTo(user.getPword());
        int count = userMapper.selectByExample(tUserExample).size();
        if (count > 0) {
            tUserExample.clear();
            return true;
        }
        tUserExample.clear();
        return false;
    }


    @Override
    public boolean forgetPword(String phoneno, String pword) {
        TUser user = new TUser();
        TUserExample userExample = new TUserExample();
        userExample.or().andPhonenoEqualTo(phoneno);
        user.setPword(pword);
        int count = userMapper.updateByExampleSelective(user, userExample);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addMoney(TUser user) {
        int count = userMapper.updateByPrimaryKey(user);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(TUser user) {
        TUserExample tUserExample = new TUserExample();
        tUserExample.or().andIdEqualTo(user.getId());
        int count = userMapper.updateByExampleSelective(user, tUserExample);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public TUser selectByPhoneno(String phoneno) {
        TUserExample userExample = new TUserExample();
        userExample.or().andPhonenoEqualTo(phoneno);
        List<TUser> userList = userMapper.selectByExample(userExample);
        return userList.get(0);
    }
}
