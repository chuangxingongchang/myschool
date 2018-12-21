package com.school.mapper;

import com.school.entity.TTime;
import com.school.entity.TTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTimeMapper {
    int countByExample(TTimeExample example);

    int deleteByExample(TTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTime record);

    int insertSelective(TTime record);

    List<TTime> selectByExample(TTimeExample example);

    TTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTime record, @Param("example") TTimeExample example);

    int updateByExample(@Param("record") TTime record, @Param("example") TTimeExample example);

    int updateByPrimaryKeySelective(TTime record);

    int updateByPrimaryKey(TTime record);
}