package com.school.service.impl;

import com.school.entity.TPlur;
import com.school.entity.TPlurExample;
import com.school.mapper.TPlurMapper;
import com.school.service.PlurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlurServiceImpl implements PlurService {
    @Autowired
    private TPlurMapper plurMapper;
    @Override
    public List<TPlur> selectAllTplur() {
        TPlurExample tPlurExample = new TPlurExample();
        return plurMapper.selectByExample(tPlurExample);
    }
}
