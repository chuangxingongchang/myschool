package com.school.mapper;

import com.school.entity.TWorkicon;
import com.school.entity.TWorkiconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWorkiconMapper {
    int countByExample(TWorkiconExample example);

    int deleteByExample(TWorkiconExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWorkicon record);

    int insertSelective(TWorkicon record);

    List<TWorkicon> selectByExample(TWorkiconExample example);

    TWorkicon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWorkicon record, @Param("example") TWorkiconExample example);

    int updateByExample(@Param("record") TWorkicon record, @Param("example") TWorkiconExample example);

    int updateByPrimaryKeySelective(TWorkicon record);

    int updateByPrimaryKey(TWorkicon record);
}