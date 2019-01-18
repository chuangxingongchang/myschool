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

}
