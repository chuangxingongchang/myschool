package com.school.mapper;

import com.school.entity.TLocation;
import com.school.entity.TLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLocationMapper {
    int countByExample(TLocationExample example);

    int deleteByExample(TLocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLocation record);

    int insertSelective(TLocation record);

    List<TLocation> selectByExample(TLocationExample example);

    TLocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLocation record, @Param("example") TLocationExample example);

    int updateByExample(@Param("record") TLocation record, @Param("example") TLocationExample example);

    int updateByPrimaryKeySelective(TLocation record);

    int updateByPrimaryKey(TLocation record);
}