package com.school.mapper;

import com.school.entity.TPlur;
import com.school.entity.TPlurExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TPlurMapper {
    int countByExample(TPlurExample example);

    int deleteByExample(TPlurExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPlur record);

    int insertSelective(TPlur record);

    List<TPlur> selectByExample(TPlurExample example);

    TPlur selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPlur record, @Param("example") TPlurExample example);

    int updateByExample(@Param("record") TPlur record, @Param("example") TPlurExample example);

    int updateByPrimaryKeySelective(TPlur record);

    int updateByPrimaryKey(TPlur record);

    List selectPlurAndcredit(Map map);

    List selectPluraccountAndtime(Map map);

    List<TPlur> selectPlurBySearch(Map map);
}