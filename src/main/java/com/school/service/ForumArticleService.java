package com.school.service;


import com.school.entity.TForumArticle;
import com.school.vo.TForumArticleVo;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/20
 * @Filde: 论坛文章Service
 */
public interface ForumArticleService {
    /**
     *  搜索栏 搜索 通过 匹配的 内容 标题 以及模糊匹配的
     * @param likeTitle article title
     * @return List<TForumArticleVo>
     */
    List<TForumArticleVo> findByTitleAndContentLikeToArticle(String likeTitle);

    /**
     * 查询 分类下 文章 一次返回start-end条
     * @param id 分类
     * @param start 开始index
     * @param end 结束 index
     * @return
     */
    List<TForumArticleVo> findByFkTypeIdToArticle(int id,int start, int end,String dateTime);

    /**
     * 通过 id 查询
     * @param article_id article_id
     * @return TForumArticle
     */
    TForumArticleVo findByTitleToArticle(int article_id);

    /**
     * Titile限制条数返回Article
     * @param title
     * @return
     */
    List<TForumArticleVo> findByTitleLikeLimite(String title);

    /**
     * 评论量
     * @param articleId 文章ID
     * @return boolean
     */
    boolean updateCommentCount(int articleId);


    /**
     * 举报验证
     * @param articleId 文章ID
     * @return boolean
     */
    boolean updateViolationCount(int articleId);

    /**
     * 查询用户文章 浏览量
     * @param userId
     * @returnro
     */
    Integer selectBrowseCountArticle(int userId);

    /**
     * 查询当前用户所有文章
     * @param userId
     * @return List<TForumArticle>
     */
    List<TForumArticle> selectArticleAll(int userId);

    /**
     * 查询用户最近动态 1-10条 时间最新
     * @param userId
     * @return List<TForumArticle>
     */
    List<TForumArticle> selectLimitArticle(int userId);

    /**
     * 查询用户发表过多少文章
     * @param userId
     * @return
     */
    Long selectArticleCount(int userId);

    /**
     * 添加文章
     * @param tForumArticle
     * @return boolean
     */
    boolean addArticle(TForumArticle tForumArticle);

    /**
     * 修改文章
     * @param tForumArticle
     * @return
     */
    boolean updateArticle(TForumArticle tForumArticle);

    /**
     * 通过 id 查询 文章
     * @param list id 集合
     * @return
     */
    List<TForumArticle> selectFindById(List<Integer> list);

    /**
     * 查询单个分类浏览量最多的文章10 篇
     * @param type_id
     * @return
     */
    List<TForumArticle> selectTypeLimitOrderDescBro(int type_id);

    /**
     * 添加文章
     * @param listArticle List集合
     * @return
     */
    boolean addListArticle(List<TForumArticle> listArticle);

    /**
     * 查询个人文章 时间排序
     * @param userId 用户
     * @param start 开始条数
     * @param end 截止条数
     * @return
     */
    List<TForumArticle> selectPersonalAllArticle(int userId, int start, int end);

    /**
     * 用户所有文章时间大于createTime
     * @param userId
     * @param start
     * @param end
     * @param createTime
     * @return
     */
    List<TForumArticle> selectPersonalArticle(int userId, int start, int end, String createTime);

}
