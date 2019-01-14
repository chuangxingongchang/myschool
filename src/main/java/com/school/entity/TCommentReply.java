package com.school.entity;

public class TCommentReply {
    private Integer id;

    private Integer fkForumCommentKey;

    private String contentText;

    private Integer fkUserKey;

    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks == null ? null : ranks.trim();
    }
}