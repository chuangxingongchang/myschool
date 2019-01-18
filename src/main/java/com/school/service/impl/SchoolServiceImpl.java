package com.school.service.impl;

import com.school.entity.TSchool;
import com.school.entity.TSchoolExample;
import com.school.mapper.TSchoolMapper;
import com.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private TSchoolMapper schoolMapper;

    @Override
    public int selectBySchoolname(String schoolname) {
        TSchoolExample schoolExample = new TSchoolExample();
        schoolExample.or().andSchoolnameEqualTo(schoolname);
        List<TSchool> schools = schoolMapper.selectByExample(schoolExample);
        int id = 0;
        if(schools!=null&&schools.size()>0){
           id  = schools.get(0).getId();
        }
        return id;
    }

    @Override
    public String selectByFkSchoolId(int fkSchoolId) {
        TSchoolExample schoolExample = new TSchoolExample();
        schoolExample.or().andIdEqualTo(fkSchoolId);
        List<TSchool> schoolList = schoolMapper.selectByExample(schoolExample);
        return schoolList.get(0).getSchoolname();
    }

    @Override
    public boolean insertSchool(TSchool school) {
        int count = schoolMapper.insertSelective(school);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkThisSchool(TSchool school) {
        TSchoolExample schoolExample = new TSchoolExample();
        schoolExample.or().andSchoolcityEqualTo(school.getSchoolcity())
                .andSchoolnameEqualTo(school.getSchoolname());
        List<TSchool> schoolList = schoolMapper.selectByExample(schoolExample);
        int count = schoolList.size();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
