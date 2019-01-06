package com.school.service;

import com.school.entity.*;

import java.util.List;

public interface PlurService {
    //查询所有兼职
    List<TPlur> selectAllTplur();

    //根据学校进行查询，用户登录根据用户的学校显示当前用户的信息
    List<TPlur> selectBySchool(int schoolId);

    //根据兼职id查询当前兼职
    TPlur selectByTplurId(int id);

    //根据当前用户查询当前用户（兼客）的所有兼职，用户可以根据兼职的状态给出自己不同存在的兼职
    List<TPlur> selectByAccept(int uid);

    //根据发布者id查询所有发布
    List<TPlur> selectByPublisher(int id);

    //根据岗位进行查询
    List<TPlur> selectByWorkType(TWorktype tWorktype);

    //根据兼职时间类型进行查询
    List<TPlur> selectByTime(TTime tTime);

    //根据结算单位进行查询
    List<TPlur> selectByUnit(TUnit tUnit);

    //查询所有的结算类型
    List<TUnit> selectAllUnit();

    //发布岗位
    boolean insertPlur(TPlur plur);
}
