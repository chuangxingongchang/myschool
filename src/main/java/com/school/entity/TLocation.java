package com.school.entity;

public class TLocation {
    private Integer id;

    private String locationtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(String locationtype) {
        this.locationtype = locationtype == null ? null : locationtype.trim();
    }
}