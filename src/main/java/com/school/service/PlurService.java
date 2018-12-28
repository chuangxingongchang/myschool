package com.school.service;

import com.school.entity.*;

import java.util.List;

public interface PlurService {
    //查询所有兼职
    List<TPlur> selectAllTplur();
    //根据学校进行查询，用户登录根据用户的学校显示当前用户的信息
    List<TPlur> selectBySchool(TSchool tSchool);
    //根据当前用户查询当前用户的所有兼职，用户可以根据兼职的状态给出自己不同存在的兼职
    List<TPlur> selectByUser(TUser tUser);
    //根据用户位置进行查询，分类兼职
    List<TPlur> selectByLocation(TLocation tLocation);
    //根据岗位进行查询
    List<TPlur> selectByWorkType(TWorktype tWorktype);
    //根据兼职时间类型进行查询
    List<TPlur> selectByTime(TTime tTime);
    //根据结算单位进行查询
    List<TPlur> selectByUnit(TUnit tUnit);
    //根据兼职查询当前兼职的图标
    TWorkicon selectByTplur(TPlur tPlur);
}
