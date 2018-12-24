package com.school.entity;

public class TSchool {
    private Integer id;

    private String schoolname;

    private String schoolcity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getSchoolcity() {
        return schoolcity;
    }

    public void setSchoolcity(String schoolcity) {
        this.schoolcity = schoolcity == null ? null : schoolcity.trim();
    }
}