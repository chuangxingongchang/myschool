package com.school.entity;

public class TWorkicon {
    private Integer id;

    private String iconlocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIconlocation() {
        return iconlocation;
    }

    public void setIconlocation(String iconlocation) {
        this.iconlocation = iconlocation == null ? null : iconlocation.trim();
    }
}