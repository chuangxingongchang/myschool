package com.school.service;

import com.school.entity.TActivityUser;

import java.util.List;

public interface ActivityUserService {

    List<TActivityUser> selectByAcId(int acId);

    boolean insertActvtUser(TActivityUser activityUser);
}
