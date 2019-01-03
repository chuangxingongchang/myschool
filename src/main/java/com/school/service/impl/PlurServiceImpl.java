package com.school.service.impl;

import com.school.entity.*;
import com.school.mapper.TPlurMapper;
import com.school.mapper.TUnitMapper;
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
    @Autowired
    private TUnitMapper unitMapper;


   // private  TPlurExample plurexample = new TPlurExample();
    //查询所有兼职
    @Override
    public List<TPlur> selectAllTplur() {
        TPlurExample tPlurExample = new TPlurExample();
        return plurMapper.selectByExample(tPlurExample);
    }
    //根据学校进行查询兼职
    @Override
    public List<TPlur> selectBySchool(int shoolId) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkSchoolEqualTo(shoolId);
        return plurMapper.selectByExample(tPlurExample);
    }
    //根据id查询当前兼职
    @Override
    public TPlur selectByTplurId(int id) {
        TPlur plur = plurMapper.selectByPrimaryKey(id);
        return plur;
    }

    //根据用户id进行查询其所有兼职
    @Override
    public List<TPlur> selectByUser(int uid) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkAcceptEqualTo(uid);
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

    @Override
    public List<TWorkicon> selectAllWorkicon() {
        TWorkiconExample workiconExample = new TWorkiconExample();
        List<TWorkicon> workiconsList = iconMapper.selectByExample(workiconExample);
        return workiconsList;
    }

    @Override
    public List<TUnit> selectAllUnit() {
        TUnitExample unitExample = new TUnitExample();
        List<TUnit> unitList = unitMapper.selectByExample(unitExample);
        return unitList;
    }
}
