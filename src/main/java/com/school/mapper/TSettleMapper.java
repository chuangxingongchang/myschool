package com.school.mapper;

import com.school.entity.TSettle;
import com.school.entity.TSettleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSettleMapper {
    int countByExample(TSettleExample example);

    int deleteByExample(TSettleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSettle record);

    int insertSelective(TSettle record);

    List<TSettle> selectByExample(TSettleExample example);

    TSettle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSettle record, @Param("example") TSettleExample example);

    int updateByExample(@Param("record") TSettle record, @Param("example") TSettleExample example);

    int updateByPrimaryKeySelective(TSettle record);

    int updateByPrimaryKey(TSettle record);
}