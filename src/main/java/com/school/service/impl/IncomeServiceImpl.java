package com.school.service.impl;

import com.school.entity.TIncome;
import com.school.entity.TIncomeExample;
import com.school.mapper.TIncomeMapper;
import com.school.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private TIncomeMapper incomeMapper;
    @Override
    public List<TIncome> selectAllIncome(int uid) {
        TIncomeExample incomeExample = new TIncomeExample();
        incomeExample.or().andFkUidEqualTo(uid);
        List<TIncome> incomeList = incomeMapper.selectByExample(incomeExample);
        return incomeList;
    }
}
