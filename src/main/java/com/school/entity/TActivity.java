package com.school.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class TActivity {
    private Integer id;

    private String titles;

    private String images;

    private String content;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date activitytime;

    private String address;

    private String precautions;

    private String claim;

    private String objects;

    private String organizer;

    private Integer currentnum;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createtime;

    private Integer fkUserid;

    private String acstate;

    private Integer fkSchool;
}