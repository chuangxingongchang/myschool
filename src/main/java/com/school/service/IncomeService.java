package com.school.service;

import com.school.entity.TIncome;

import java.util.List;

public interface IncomeService {
    List<TIncome> selectAllIncome(int uid);
}
