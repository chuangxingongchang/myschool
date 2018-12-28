package com.school.service.impl;

import com.school.entity.*;
import com.school.mapper.TPlurMapper;
import com.school.mapper.TWorkiconMapper;
import com.school.service.PlurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlurServiceImpl implements PlurService {
    @Autowired
    private TPlurMapper plurMapper;
    @Autowired
    private TWorkiconMapper iconMapper;

   // private  TPlurExample plurexample = new TPlurExample();
    //查询所有兼职
    @Override
    public List<TPlur> selectAllTplur() {
        TPlurExample tPlurExample = new TPlurExample();
        return plurMapper.selectByExample(tPlurExample);
    }
    //根据学校进行查询兼职
    @Override
    public List<TPlur> selectBySchool(TSchool tSchool) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkSchoolEqualTo(tSchool.getId());
        return plurMapper.selectByExample(tPlurExample);
    }
    //根据用户进行查询兼职
    @Override
    public List<TPlur> selectByUser(TUser tUser) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkAcceptEqualTo(tUser.getId());
        return plurMapper.selectByExample(tPlurExample);
    }

    //根据位置属性进行查询兼职
    @Override
    public List<TPlur> selectByLocation(TLocation tLocation) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkLocationtypeEqualTo(tLocation.getId());
        return  plurMapper.selectByExample(tPlurExample);
    }

    //根据工作类型属性进行查询兼职
    @Override
    public List<TPlur> selectByWorkType(TWorktype tWorktype) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkWorktypeEqualTo(tWorktype.getId());
        return  plurMapper.selectByExample(tPlurExample);
    }

    //根据时间属性进行查询兼职
    @Override
    public List<TPlur> selectByTime(TTime tTime) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkTimetypeEqualTo(tTime.getId());
        return  plurMapper.selectByExample(tPlurExample);
    }
    //根据结算单位属性进行查询兼职
    @Override
    public List<TPlur> selectByUnit(TUnit tUnit) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkUnitEqualTo(tUnit.getId());
        return  plurMapper.selectByExample(tPlurExample);
    }

    //获取当前兼职的图标
    @Override
    public TWorkicon selectByTplur(TPlur tPlur) {
      TWorkicon icon  = iconMapper.selectByPrimaryKey(tPlur.getFkWorkicon());
        return  icon;
    }
}
