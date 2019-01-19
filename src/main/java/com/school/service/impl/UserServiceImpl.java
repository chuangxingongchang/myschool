package com.school.service.impl;

import com.school.entity.TUser;
import com.school.entity.TUserExample;
import com.school.mapper.TUserMapper;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Override
    public List<TUser> selectAllUser() {
        TUserExample userExample = new TUserExample();
        List<TUser> userList = userMapper.selectByExample(userExample);
        if(userList==null&&userList.size()<=0){
            return null;
        }
        return userList;
    }

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

    @Override
    public TUser selectById(int id) {
       TUser user = userMapper.selectByPrimaryKey(id);
       return user;
    }
    @Override
    public List<TUser> selectUserIdIn(List<Integer> id) {
        TUserExample tue = new TUserExample();
        List<TUser> lu = new ArrayList<>();
        if (id.size() !=0) {
            tue.or()
                    .andIdIn(id);
            lu = userMapper.selectByExample(tue);
        }
        return lu;
    }

    @Override
    public TUser selectNicknameById(int uid) {
        TUserExample userExample = new TUserExample();
        userExample.setOrderByClause("nickname");
        TUser user = userMapper.selectByPrimaryKey(uid);
        return user;
    }
}
