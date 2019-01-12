package com.school.mapper;

import com.school.entity.TIncome;
import com.school.entity.TIncomeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TIncomeMapper {
    int countByExample(TIncomeExample example);

    int deleteByExample(TIncomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TIncome record);

    int insertSelective(TIncome record);

    List<TIncome> selectByExample(TIncomeExample example);

    TIncome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TIncome record, @Param("example") TIncomeExample example);

    int updateByExample(@Param("record") TIncome record, @Param("example") TIncomeExample example);

    int updateByPrimaryKeySelective(TIncome record);

    int updateByPrimaryKey(TIncome record);
}