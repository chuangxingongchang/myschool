package com.school.service;

import com.school.entity.TForumComment;

import java.util.List;

/**
 * @Auther: XiTao
 * @Date: 2018/12/22
 * @Field: 文章评论Service
 */
public interface ForumCommentService {
    /**
     * 通过FK_Article_Key查询Comment
     * @param id
     * @return
     */
    List<TForumComment> selectFkIdToComment(int id);

    /**
     * 添加评论
     * @param tForumComment
     * @return boolean
     */
    boolean addComment(TForumComment tForumComment);

    /**
     *  查询个人评论过得帖子 去重
     * @param id
     * @param start
     * @param end
     * @return
     */
        List<Integer> selectFindByUserIdComment(int id,int start,int end);

    /**
     * 查询大于 createTime 的comment
     * @param id
     * @param start
     * @param end
     * @param createTime
     * @return
     */
        List<Integer>   selectNewsTimeComment(int id,int start,int end,String createTime);
}
