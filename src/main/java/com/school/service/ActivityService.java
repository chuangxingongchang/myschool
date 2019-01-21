package com.school.service;

import com.school.entity.TActivity;

import java.util.List;

public interface ActivityService {

    List<TActivity> selectAll();

    List<TActivity> selectAllByTimeSort();

    List<TActivity> selectAllByNumberSort();

    TActivity selectActivityById(int id);

    boolean addActivity(TActivity activity);

    List<TActivity> selectByUserIdActivity(int fkUserid);

    boolean deleteActivity(int id);

    boolean updateActvtCurrentNum(TActivity activity);
    //根据学校和状态发布（值:1）进行查询所有活动，并按发布时间进行排序
    List<TActivity> selectActivityByTime(String schoolname);

}
