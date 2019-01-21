package com.school.entity;

import lombok.Data;

import java.util.Date;
@Data
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

    private String acstate;


}