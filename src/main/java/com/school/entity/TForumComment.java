package com.school.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TForumComment {
    private Integer id;

    private Integer fkForumArticleKey;

    private Integer fkUserKey;

    private String ranks;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String contentText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkForumArticleKey() {
        return fkForumArticleKey;
    }

    public void setFkForumArticleKey(Integer fkForumArticleKey) {
        this.fkForumArticleKey = fkForumArticleKey;
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks == null ? null : ranks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }

    @Override
    public String toString() {
        return "TForumComment{" +
                "id=" + id +
                ", fkForumArticleKey=" + fkForumArticleKey +
                ", fkUserKey=" + fkUserKey +
                ", ranks='" + ranks + '\'' +
                ", createTime='" + createTime + '\'' +
                ", contentText='" + contentText + '\'' +
                '}';
    }
}