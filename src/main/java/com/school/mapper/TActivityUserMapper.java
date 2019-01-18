package com.school.mapper;

import com.school.entity.TActivityUser;
import com.school.entity.TActivityUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActivityUserMapper {
    int countByExample(TActivityUserExample example);

    int deleteByExample(TActivityUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TActivityUser record);

    int insertSelective(TActivityUser record);

    List<TActivityUser> selectByExample(TActivityUserExample example);

    TActivityUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TActivityUser record, @Param("example") TActivityUserExample example);

    int updateByExample(@Param("record") TActivityUser record, @Param("example") TActivityUserExample example);

    int updateByPrimaryKeySelective(TActivityUser record);

    int updateByPrimaryKey(TActivityUser record);
}