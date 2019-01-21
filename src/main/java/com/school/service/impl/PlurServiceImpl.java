package com.school.service.impl;

import com.school.entity.*;
import com.school.mapper.TPlurMapper;
import com.school.mapper.TSchoolMapper;
import com.school.mapper.TSignupMapper;
import com.school.mapper.TUnitMapper;
import com.school.service.PlurService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlurServiceImpl implements PlurService {
    @Autowired
    private TPlurMapper plurMapper;
    @Autowired
    private TUnitMapper unitMapper;
    @Autowired
    private TSchoolMapper schoolMapper;
    @Autowired
    private TSignupMapper signupMapper;

    //查询所有兼职
    @Override
    public List<TPlur> selectAllTplur() {
        TPlurExample tPlurExample = new TPlurExample();
        return plurMapper.selectByExample(tPlurExample);
    }
    //根据学校进行查询兼职,时间先后
    @Override
    public List<TPlur> selectBySchool(int shoolId) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkSchoolEqualTo(shoolId)
                .andFkWorkstateEqualTo(1);
        tPlurExample.setOrderByClause("releaseTime desc");
        return plurMapper.selectByExample(tPlurExample);
    }
    //学校兼职热门显示
    @Override
    public List<TPlur> selectBySchoolCount(int fkSchoolId) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkSchoolEqualTo(fkSchoolId)
                .andFkWorkstateEqualTo(1);
        tPlurExample.setOrderByClause("counts desc");
        return plurMapper.selectByExample(tPlurExample);
    }
    //学校兼职信用度显示
    @Override
    public List<SchoolCreditPlur> selectBySchoolCredit(int fkSchoolId) {
        Map map = new HashMap();
        map.put("schoolId",fkSchoolId);
        map.put("fkWorkstate",1);
        List<SchoolCreditPlur> list = plurMapper.selectPlurAndcredit(map);
        if(null!=list){
            return list;
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                return  null;
            }
        }
    }

    @Override
    public List<TPlur> selectByaccountAndtimeDesc(String schoolname) {
        Map map = new HashMap();
        TSchoolExample schoolExample = new TSchoolExample();
        TSchoolExample schoolExample1 = new TSchoolExample();
        schoolExample1.or().andSchoolnameEqualTo(schoolname);
        List<TSchool> schoolList = schoolMapper.selectByExample(schoolExample1);

        if(schoolList!=null||schoolList.size()>0){
            schoolExample.or().andSchoolnameEqualTo(schoolname);
        }else{
            TSchool school = new TSchool();
            school.setSchoolname(schoolname);
            schoolMapper.insertSelective(school);
            return null;
        }
        List<TSchool> schools = null;
        try {
            schools = schoolMapper.selectByExample(schoolExample);
        }catch (Exception e){
            return null;
        }
         int id = schools.get(0).getId();
        map.put("schoolId",id);
        map.put("fkWorkstate",1);
        List<TPlur> tPlurList = plurMapper.selectPluraccountAndtime(map);

        if(tPlurList!=null&&tPlurList.size()>0){
            return  tPlurList;
        }else{
            try {
                throw  new Exception();
            } catch (Exception e) {
                return null;
            }
        }
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
        TSignupExample signupExample = new TSignupExample();
        signupExample.or().andPkUidEqualTo(uid);
        List<TSignup> signupList = signupMapper.selectByExample(signupExample);
        List<TPlur> plurList = new ArrayList<TPlur>();
        if(signupList!=null&&signupList.size()>0){
            for (TSignup s : signupList) {
                if(s.getPkPlurid()!=null){
                    TPlur p = plurMapper.selectByPrimaryKey(s.getPkPlurid());
                    plurList.add(p);
                }
            }
        }else{

        }
       return plurList;
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

    @Override
    public boolean updateCounts(int id, int counts) {
        TPlurExample tPlurExample = new TPlurExample();
        TPlur plur  = new TPlur();
        plur.setCounts(counts);
        tPlurExample.or().andIdEqualTo(id);
       int b =  plurMapper.updateByExampleSelective(plur,tPlurExample);
       if(b>0){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public List<TPlur> selectPlurBySL(int fkSchoolId, int fkTimetype) {
        TPlurExample plurExample = new TPlurExample();
        plurExample.or().andFkSchoolEqualTo(fkSchoolId)
                .andFkTimetypeEqualTo(fkTimetype)
                .andFkWorkstateEqualTo(1);
        List<TPlur> tPlurList = plurMapper.selectByExample(plurExample);
        return tPlurList;
    }

    @Override
    public List<TPlur> selectPlurBytoSearch(String searchname,String schoolname) {
        List<TPlur> tPlurList = null;
        Map map  = new HashMap();
        TSchoolExample schoolExample = new TSchoolExample();
        TSchoolExample schoolExample1 = new TSchoolExample();
        schoolExample1.or().andSchoolnameEqualTo(schoolname);
        List<TSchool> schoolList = schoolMapper.selectByExample(schoolExample1);

        if(schoolList!=null||schoolList.size()>0){
            schoolExample.or().andSchoolnameEqualTo(schoolname);
        }else{
            TSchool school = new TSchool();
            school.setSchoolname(schoolname);
            schoolMapper.insertSelective(school);
            return null;
        }
        List<TSchool> schools = null;
        int id = 0;
        try {
            schools = schoolMapper.selectByExample(schoolExample);
            id = schools.get(0).getId();
            if(searchname!=null&&searchname!=""){
                map.put("searchname",searchname);
                map.put("schoolId",id);
                tPlurList = plurMapper.selectPlurBySearch(map);
            }
        }catch (Exception e){
            return  null;
        }
        return tPlurList;
    }

    @Override
    public Message deletePlurById(int id) {
        Message ms = new Message();
        int a  = 0;
        try{
            a = plurMapper.deleteByPrimaryKey(id);
            if(a>0){
               ms.setStatus(true);
            }else{
                ms.setStatus(false);
            }
        }catch (Exception e){
            ms.setStatus(false);
        }
        return ms;
    }
}
