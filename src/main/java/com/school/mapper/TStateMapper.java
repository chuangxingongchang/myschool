package com.school.mapper;

import com.school.entity.TState;
import com.school.entity.TStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStateMapper {
    int countByExample(TStateExample example);

    int deleteByExample(TStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TState record);

    int insertSelective(TState record);

    List<TState> selectByExample(TStateExample example);

    TState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TState record, @Param("example") TStateExample example);

    int updateByExample(@Param("record") TState record, @Param("example") TStateExample example);

    int updateByPrimaryKeySelective(TState record);

    int updateByPrimaryKey(TState record);
}