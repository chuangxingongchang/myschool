package com.school.mapper;

import com.school.entity.TSchool;
import com.school.entity.TSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSchoolMapper {
    int countByExample(TSchoolExample example);

    int deleteByExample(TSchoolExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSchool record);

    int insertSelective(TSchool record);

    List<TSchool> selectByExample(TSchoolExample example);

    TSchool selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSchool record, @Param("example") TSchoolExample example);

    int updateByExample(@Param("record") TSchool record, @Param("example") TSchoolExample example);

    int updateByPrimaryKeySelective(TSchool record);

    int updateByPrimaryKey(TSchool record);
}