package com.school.mapper;

import com.school.entity.TWorktype;
import com.school.entity.TWorktypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWorktypeMapper {
    int countByExample(TWorktypeExample example);

    int deleteByExample(TWorktypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWorktype record);

    int insertSelective(TWorktype record);

    List<TWorktype> selectByExample(TWorktypeExample example);

    TWorktype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWorktype record, @Param("example") TWorktypeExample example);

    int updateByExample(@Param("record") TWorktype record, @Param("example") TWorktypeExample example);

    int updateByPrimaryKeySelective(TWorktype record);

    int updateByPrimaryKey(TWorktype record);
}