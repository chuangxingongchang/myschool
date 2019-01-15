package com.school.vo;

public class ActivityVo {

    private String titles;

    private String images;

    private String content;

    private String activitytime;

    private String address;

    private String precautions;

    private String claim;

    private String objects;

    private String organizer;

    private String createtime;

    private Integer fkUserid;


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

    public String getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(String activitytime) {
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
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
        return "ActivityVo{" +
                ", titles='" + titles + '\'' +
                ", images='" + images + '\'' +
                ", content='" + content + '\'' +
                ", activitytime='" + activitytime + '\'' +
                ", address='" + address + '\'' +
                ", precautions='" + precautions + '\'' +
                ", claim='" + claim + '\'' +
                ", objects='" + objects + '\'' +
                ", organizer='" + organizer + '\'' +
                ", createtime='" + createtime + '\'' +
                ", fkUserid=" + fkUserid +
                '}';
    }
}
