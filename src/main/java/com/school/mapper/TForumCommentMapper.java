package com.school.mapper;

import com.school.entity.TForumComment;
import com.school.entity.TForumCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TForumCommentMapper {
    long countByExample(TForumCommentExample example);

    int deleteByExample(TForumCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumComment record);

    int insertSelective(TForumComment record);

    List<TForumComment> selectByExample(TForumCommentExample example);

    TForumComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TForumComment record, @Param("example") TForumCommentExample example);

    int updateByExample(@Param("record") TForumComment record, @Param("example") TForumCommentExample example);

    int updateByPrimaryKeySelective(TForumComment record);

    int updateByPrimaryKey(TForumComment record);

    List<Integer> selectCommentByUserId(Map map);

    List<Integer> selectNewsTimeCommentByUserId(Map map);

    int addComment(TForumComment tForumComment);
}