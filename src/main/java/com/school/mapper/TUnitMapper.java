package com.school.mapper;

import com.school.entity.TUnit;
import com.school.entity.TUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUnitMapper {
    int countByExample(TUnitExample example);

    int deleteByExample(TUnitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUnit record);

    int insertSelective(TUnit record);

    List<TUnit> selectByExample(TUnitExample example);

    TUnit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUnit record, @Param("example") TUnitExample example);

    int updateByExample(@Param("record") TUnit record, @Param("example") TUnitExample example);

    int updateByPrimaryKeySelective(TUnit record);

    int updateByPrimaryKey(TUnit record);
}