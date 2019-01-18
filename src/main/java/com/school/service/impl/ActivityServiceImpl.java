package com.school.service.impl;

import com.school.entity.TActivity;
import com.school.entity.TActivityExample;
import com.school.mapper.TActivityMapper;
import com.school.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private TActivityMapper activityMapper;

    @Override
    public List<TActivity> selectAll() {
        TActivityExample activityExample = new TActivityExample();
        List<TActivity> activityList = activityMapper.selectByExample(activityExample);
        return activityList;
    }

    @Override
    public List<TActivity> selectAllByTimeSort() {
        TActivityExample activityExample = new TActivityExample();
        activityExample.setOrderByClause("createTime desc");
        List<TActivity> activityList = activityMapper.selectByExample(activityExample);
        return activityList;
    }

    @Override
    public List<TActivity> selectAllByNumberSort() {
        TActivityExample activityExample = new TActivityExample();
        activityExample.setOrderByClause("currentNum desc");
        List<TActivity> activityList = activityMapper.selectByExample(activityExample);
        return activityList;
    }

    @Override
    public TActivity selectActivityById(int id) {
        TActivity tActivity = activityMapper.selectByPrimaryKey(id);
        return tActivity;
    }

    @Override
    public boolean addActivity(TActivity activity) {
        int count = activityMapper.insertSelective(activity);
        if(count>0){
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public List<TActivity> selectByUserIdActivity(int fkUserid) {
        TActivityExample activityExample = new TActivityExample();
        activityExample.or().andFkUseridEqualTo(fkUserid);
        List<TActivity> activityList = activityMapper.selectByExample(activityExample);
        return activityList;
    }

    @Override
    public boolean deleteActivity(int id) {
        int count = activityMapper.deleteByPrimaryKey(id);
        if (count>0){
            return true;
        }else {
            return false;
        }
    }


}
