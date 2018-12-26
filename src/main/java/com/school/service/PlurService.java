package com.school.service;

import com.school.entity.TPlur;
import com.school.entity.TSchool;
import com.school.entity.TUser;

import java.util.List;

public interface PlurService {
    List<TPlur> selectAllTplur();
    List<TPlur> selectBySchool(TSchool tSchool);
    List<TPlur> selectByUser(TUser tUser);
}
