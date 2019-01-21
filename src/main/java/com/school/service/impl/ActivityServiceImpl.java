package com.school.service.impl;

import com.school.entity.TActivity;
import com.school.entity.TActivityExample;
import com.school.entity.TSchool;
import com.school.entity.TSchoolExample;
import com.school.mapper.TActivityMapper;
import com.school.mapper.TSchoolMapper;
import com.school.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private TActivityMapper activityMapper;
    @Autowired
    private TSchoolMapper schoolMapper;

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

    @Override
    public boolean updateActvtCurrentNum(TActivity activity) {
        TActivityExample activityExample = new TActivityExample();
        TActivity activity1 = new TActivity();
        activity1.setCurrentnum(activity.getCurrentnum()+1);
        activityExample.or().andCurrentnumEqualTo(activity.getCurrentnum());
        int count = activityMapper.updateByExampleSelective(activity1, activityExample);
        if(count>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<TActivity> selectActivityByTime(String schoolname) {
        TSchoolExample shoolExample = new TSchoolExample();
        shoolExample.or().andSchoolnameEqualTo(schoolname);
        List<TSchool> schoolList = schoolMapper.selectByExample(shoolExample);
        int schoolid = 0;
        List<TActivity> activityList = null;
        if(schoolList!=null){
            schoolid = schoolList.get(0).getId();
            TActivityExample activityExample = new TActivityExample();
            activityExample.or().andFkSchoolEqualTo(schoolid)
                    .andAcstateEqualTo("1");
            activityExample.setOrderByClause("createTime desc");
            activityList = activityMapper.selectByExample(activityExample);
        }else{
            TSchool school = new TSchool();
            school.setSchoolname(schoolname);
            int b = schoolMapper.insertSelective(school);
            return null;
        }
        return activityList;
    }


}
