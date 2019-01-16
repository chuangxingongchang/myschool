package com.school.entity;

import lombok.Data;

@Data
public class SchoolCreditPlur {
    private Integer id;

    private String subject;

    private Double money;

    private Integer fk_unit;

    private String releasetime;

    private Integer counts;

    private Integer persons;

    private Integer fk_settle;

    private String wordtime;

    private String endtime;

    private String workcontent;

    private Integer fk_publisher;

    private Integer fk_accept;

    private String workaddress;

    private Integer fk_workState;

    private Integer fk_timeType;

    private Integer fk_workType;

    private Integer fk_school;

    private Integer credit;
}
