package com.school.service.impl;

import com.school.entity.*;
import com.school.mapper.TSettleMapper;
import com.school.mapper.TTimeMapper;
import com.school.mapper.TUnitMapper;
import com.school.mapper.TWorktypeMapper;
import com.school.service.JobAllUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAllUnitServiceImpl implements JobAllUnitService {
    @Autowired
    private TWorktypeMapper worktypeMapper;
    @Autowired
    private TTimeMapper timeMapper;
    @Autowired
    private TUnitMapper unitMapper;
    @Autowired
    private TSettleMapper settleMapper;
    @Override
    public List<TWorktype> selectAllWorkType() {
        TWorktypeExample worktypeExample = new TWorktypeExample();
       return worktypeMapper.selectByExample(worktypeExample);
    }

    @Override
    public List<TTime> selectAllTime() {
        TTimeExample timeExample  = new TTimeExample();
        return timeMapper.selectByExample(timeExample);
    }

    @Override
    public List<TUnit> selectAllUnit() {
        TUnitExample unitExample  = new TUnitExample();
        return unitMapper.selectByExample(unitExample);
    }

    @Override
    public List<TSettle> selectAllSettle() {
        TSettleExample settleExample = new TSettleExample();
        return settleMapper.selectByExample(settleExample);
    }
}
