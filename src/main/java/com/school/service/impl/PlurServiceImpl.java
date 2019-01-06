package com.school.service.impl;

import com.school.entity.*;
import com.school.mapper.TPlurMapper;
import com.school.mapper.TUnitMapper;
import com.school.service.PlurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlurServiceImpl implements PlurService {
    @Autowired
    private TPlurMapper plurMapper;
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
    public List<TPlur> selectByAccept(int uid) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkAcceptEqualTo(uid);
        return plurMapper.selectByExample(tPlurExample);
    }

    @Override
    public List<TPlur> selectByPublisher(int id) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkPublisherEqualTo(id);
        List<TPlur> plurList = plurMapper.selectByExample(tPlurExample);
        return plurList;
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

    @Override
    public List<TUnit> selectAllUnit() {
        TUnitExample unitExample = new TUnitExample();
        List<TUnit> unitList = unitMapper.selectByExample(unitExample);
        return unitList;
    }

    @Override
    public boolean insertPlur(TPlur plur) {
        int b = plurMapper.insertSelective(plur);
        if(b>0){
            return true;
        }else {
            return false;
        }
    }
}
