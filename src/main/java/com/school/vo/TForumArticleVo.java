package com.school.vo;

import com.school.entity.TUser;

import java.util.Date;

public class TForumArticleVo {
    private Integer id;

    private String title;

    private Integer fkForumTypeKey;

    private String contentText;

    private String createTime;

    private TUser fkUserKey;

    private Integer violationCount;

    private Integer applaud;

    private Integer browseConut;

    private Integer commentCount;

    private String contentDescribe;

    private String isNull;

    private Integer isNullInt;

    public String getContentDescribe() {
        return contentDescribe;
    }

    public void setContentDescribe(String contentDescribe) {
        this.contentDescribe = contentDescribe;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public Integer getIsNullInt() {
        return isNullInt;
    }

    public void setIsNullInt(Integer isNullInt) {
        this.isNullInt = isNullInt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getFkForumTypeKey() {
        return fkForumTypeKey;
    }

    public void setFkForumTypeKey(Integer fkForumTypeKey) {
        this.fkForumTypeKey = fkForumTypeKey;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ?null :  contentText.trim();;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public TUser getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(TUser fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public Integer getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(Integer violationCount) {
        this.violationCount = violationCount;
    }

    public Integer getApplaud() {
        return applaud;
    }

    public void setApplaud(Integer applaud) {
        this.applaud = applaud;
    }

    public Integer getBrowseConut() {
        return browseConut;
    }

    public void setBrowseConut(Integer browseConut) {
        this.browseConut = browseConut;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "TForumArticleVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fkForumTypeKey=" + fkForumTypeKey +
                ", contentText='" + contentText + '\'' +
                ", createTime=" + createTime +
                ", fkUserKey=" + fkUserKey +
                ", violationCount=" + violationCount +
                ", applaud=" + applaud +
                ", browseConut=" + browseConut +
                ", commentCount=" + commentCount +
                '}';
    }
}