package com.school.mapper;

import com.school.entity.TSignup;
import com.school.entity.TSignupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSignupMapper {
    int countByExample(TSignupExample example);

    int deleteByExample(TSignupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSignup record);

    int insertSelective(TSignup record);

    List<TSignup> selectByExample(TSignupExample example);

    TSignup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSignup record, @Param("example") TSignupExample example);

    int updateByExample(@Param("record") TSignup record, @Param("example") TSignupExample example);

    int updateByPrimaryKeySelective(TSignup record);

    int updateByPrimaryKey(TSignup record);
}