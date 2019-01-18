package com.school.service;

import com.school.entity.*;

import java.util.List;

public interface PlurService {
    //查询所有兼职
    List<TPlur> selectAllTplur();

    //根据学校按时间先后顺序进行查询，用户登录根据用户的学校显示当前用户的信息
    List<TPlur> selectBySchool(int schoolId);

    //根据学校访问次数，进行兼职的热门查询
    List<TPlur> selectBySchoolCount(int schoolId);

    //根据用户的信用度进行查询
    List<SchoolCreditPlur> selectBySchoolCredit(int schoolId);

    //查询学校根据访问次数及发布时间进行排序
    List<TPlur>  selectByaccountAndtimeDesc(String schoolname);

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
    //更新访问次数
    boolean updateCounts(int id,int counts);
    //根据学校查询短期、长期
    List<TPlur> selectPlurBySL(int fkSchoolId,int fkTimetype);

    //根据主题进行模糊搜索
    List<TPlur> selectPlurBytoSearch(String searchname,String schoolname);
}
