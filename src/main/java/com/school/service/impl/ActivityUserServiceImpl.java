package com.school.service.impl;

import com.school.entity.TActivityUser;
import com.school.entity.TActivityUserExample;
import com.school.mapper.TActivityUserMapper;
import com.school.service.ActivityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityUserServiceImpl implements ActivityUserService {
    @Autowired
    private TActivityUserMapper activityUserMapper;

    @Override
    public List<TActivityUser> selectByAcId(int acId) {
        TActivityUserExample activityUserExample = new TActivityUserExample();
        activityUserExample.or()
                .andAcIdEqualTo(acId);
        List<TActivityUser> activityUserList = activityUserMapper.selectByExample(activityUserExample);
        return activityUserList;
    }

    @Override
    public boolean insertActvtUser(TActivityUser a) {
        TActivityUserExample activityUserExample = new TActivityUserExample();
        activityUserExample.or().andAcIdEqualTo(a.getAcId())
                .andUserIdEqualTo(a.getUserId());
        List<TActivityUser> activityUserList = activityUserMapper.selectByExample(activityUserExample);
        if(activityUserList!=null&&activityUserList.size()>0){
            return false;
        }else{
            int count = activityUserMapper.insertSelective(a);
            if(count>0){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public List<TActivityUser> selectActivityUsers(Integer caId) {
        TActivityUserExample activityUserExample = new TActivityUserExample();
        activityUserExample.or().andAcIdEqualTo(caId);
        List<TActivityUser> activityUserList = activityUserMapper.selectByExample(activityUserExample);
        return activityUserList;
    }
}
