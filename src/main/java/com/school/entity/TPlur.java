package com.school.entity;

import lombok.Data;

@Data
public class TPlur {
    private Integer id;

    private String subject;

    private Double money;

    private Integer fkUnit;

    private String releasetime;

    private Integer counts;

    private Integer persons;

    private Integer fkSettle;

    private String wordtime;

    private String endtime;

    private String workcontent;

    private Integer fkPublisher;

    private Integer fkAccept;

    private String workaddress;

    private Integer fkWorkstate;

    private Integer fkTimetype;

    private Integer fkWorktype;

    private Integer fkSchool;
}