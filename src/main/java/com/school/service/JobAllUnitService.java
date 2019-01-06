package com.school.service;

import com.school.entity.TSettle;
import com.school.entity.TTime;
import com.school.entity.TUnit;
import com.school.entity.TWorktype;

import java.util.List;

public interface JobAllUnitService {
    List<TWorktype> selectAllWorkType();
    List<TTime>     selectAllTime();
    List<TUnit>     selectAllUnit();
    List<TSettle>     selectAllSettle();
}
