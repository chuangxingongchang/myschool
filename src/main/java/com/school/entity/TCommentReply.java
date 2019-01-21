package com.school.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TCommentReply {
    private Integer id;

    private Integer fkForumCommentKey;

    private String contentText;

    private Integer fkUserKey;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String ranks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkForumCommentKey() {
        return fkForumCommentKey;
    }

    public void setFkForumCommentKey(Integer fkForumCommentKey) {
        this.fkForumCommentKey = fkForumCommentKey;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks == null ? null : ranks.trim();
    }
}