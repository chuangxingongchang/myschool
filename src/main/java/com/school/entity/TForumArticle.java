package com.school.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TForumArticle {
    private Integer id;

    private String title;

    private Integer fkForumTypeKey;

    private String contentText;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date createTime;

    private Integer fkUserKey;

    private Integer violationCount;

    private Integer fkApplaudStatus;

    private Integer browseConut;

    private Integer commentCount;

    private String contentDescribe;

    private String isNull;

    private Integer isNullInt;

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
        this.contentText = contentText == null ? null : contentText.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFkUserKey() {
        return fkUserKey;
    }

    public void setFkUserKey(Integer fkUserKey) {
        this.fkUserKey = fkUserKey;
    }

    public Integer getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(Integer violationCount) {
        this.violationCount = violationCount;
    }

    public Integer getFkApplaudStatus() {
        return fkApplaudStatus;
    }

    public void setFkApplaudStatus(Integer fkApplaudStatus) {
        this.fkApplaudStatus = fkApplaudStatus;
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

    public String getContentDescribe() {
        return contentDescribe;
    }

    public void setContentDescribe(String contentDescribe) {
        this.contentDescribe = contentDescribe == null ? null : contentDescribe.trim();
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull == null ? null : isNull.trim();
    }

    public Integer getIsNullInt() {
        return isNullInt;
    }

    public void setIsNullInt(Integer isNullInt) {
        this.isNullInt = isNullInt;
    }
}