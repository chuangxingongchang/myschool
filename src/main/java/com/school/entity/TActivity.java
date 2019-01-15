package com.school.entity;

import java.util.Date;

public class TActivity {
    private Integer id;

    private String titles;

    private String images;

    private String content;

    private Date activitytime;

    private String address;

    private String precautions;

    private String claim;

    private String objects;

    private String organizer;

    private Integer currentnum;

    private Date createtime;

    private Integer fkUserid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(Date activitytime) {
        this.activitytime = activitytime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Integer getCurrentnum() {
        return currentnum;
    }

    public void setCurrentnum(Integer currentnum) {
        this.currentnum = currentnum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFkUserid() {
        return fkUserid;
    }

    public void setFkUserid(Integer fkUserid) {
        this.fkUserid = fkUserid;
    }

    @Override
    public String toString() {
        return "TActivity{" +
                "id=" + id +
                ", titles='" + titles + '\'' +
                ", images='" + images + '\'' +
                ", content='" + content + '\'' +
                ", activitytime=" + activitytime +
                ", address='" + address + '\'' +
                ", precautions='" + precautions + '\'' +
                ", claim='" + claim + '\'' +
                ", objects='" + objects + '\'' +
                ", organizer='" + organizer + '\'' +
                ", currentnum=" + currentnum +
                ", createtime=" + createtime +
                ", fkUserid=" + fkUserid +
                '}';
    }
}