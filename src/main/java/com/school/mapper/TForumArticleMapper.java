package com.school.mapper;

import com.school.entity.TForumArticle;
import com.school.entity.TForumArticleExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TForumArticleMapper {
    int countByExample(TForumArticleExample example);

    int deleteByExample(TForumArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TForumArticle record);

    int insertSelective(TForumArticle record);

    List<TForumArticle> selectByExample(TForumArticleExample example);

    TForumArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TForumArticle record, @Param("example") TForumArticleExample example);

    int updateByExample(@Param("record") TForumArticle record, @Param("example") TForumArticleExample example);

    int updateByPrimaryKeySelective(TForumArticle record);

    int updateByPrimaryKey(TForumArticle record);

    Integer selectBrowseCount(int userId);

    List<TForumArticle> selectLimitArticle(int userId);

    List<TForumArticle> selectLimitOrderDescBrow(int typeId);

    List<TForumArticle> selectLimitOrderTimeDescAndWhere(Map<String, Object> map);

    List<TForumArticle> selectPersonalAllArticle(Map<String, Object> map);

    List<TForumArticle> selectPersonalArticle(Map<String, Object> map);

    List<TForumArticle> selectTitleLimit(Map<String, Object> map);

    List<TForumArticle> selectContentLimit(Map<String, Object> map);

    List<TForumArticle> selectTitleLikeLimit(Map<String, Object> map);

    List<TForumArticle> selectContentLikeLimit(Map<String, Object> map);

    /**
     * 查询最新文章 并且 去重
     * @param map
     * @return
     */
    List<TForumArticle> selectNewsArticle(Map<String, Object> map);
}