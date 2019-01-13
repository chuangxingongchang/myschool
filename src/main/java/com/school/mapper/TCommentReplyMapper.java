package com.school.mapper;

import com.school.entity.TCommentReply;
import com.school.entity.TCommentReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCommentReplyMapper {
    int countByExample(TCommentReplyExample example);

    int deleteByExample(TCommentReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCommentReply record);

    int insertSelective(TCommentReply record);

    List<TCommentReply> selectByExample(TCommentReplyExample example);

    TCommentReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCommentReply record, @Param("example") TCommentReplyExample example);

    int updateByExample(@Param("record") TCommentReply record, @Param("example") TCommentReplyExample example);

    int updateByPrimaryKeySelective(TCommentReply record);

    int updateByPrimaryKey(TCommentReply record);
}