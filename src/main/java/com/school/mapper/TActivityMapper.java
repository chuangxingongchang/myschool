package com.school.mapper;

import com.school.entity.TActivity;
import com.school.entity.TActivityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TActivityMapper {
    int countByExample(TActivityExample example);

    int deleteByExample(TActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    List<TActivity> selectByExample(TActivityExample example);

    TActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByExample(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);

}