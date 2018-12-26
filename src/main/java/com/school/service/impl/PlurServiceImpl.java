package com.school.service.impl;

import com.school.entity.TPlur;
import com.school.entity.TPlurExample;
import com.school.entity.TSchool;
import com.school.entity.TUser;
import com.school.mapper.TPlurMapper;
import com.school.service.PlurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlurServiceImpl implements PlurService {
    @Autowired
    private TPlurMapper plurMapper;
    @Override
    public List<TPlur> selectAllTplur() {
        TPlurExample tPlurExample = new TPlurExample();
        return plurMapper.selectByExample(tPlurExample);
    }

    @Override
    public List<TPlur> selectBySchool(TSchool tSchool) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkSchoolEqualTo(tSchool.getId());
        return plurMapper.selectByExample(tPlurExample);
    }

    @Override
    public List<TPlur> selectByUser(TUser tUser) {
        TPlurExample tPlurExample = new TPlurExample();
        tPlurExample.or().andFkAcceptEqualTo(tUser.getId());
        return plurMapper.selectByExample(tPlurExample);
    }
}
