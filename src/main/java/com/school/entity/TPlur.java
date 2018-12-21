package com.school.entity;

import lombok.Data;

import java.util.Date;
@Data
public class TPlur {
    private Integer id;

    private String subject;

    private Double money;

    private Integer fkUnit;

    private Date releasetime;

    private Integer counts;

    private Integer persons;

    private String settlemethod;

    private String wordtime;

    private Date endtime;

    private String workcontent;

    private Integer fkPublisher;

    private Integer fkAccept;

    private String workaddress;

    private Integer fkWorkicon;

    private Integer fkWorkstate;

    private Integer fkLocationtype;

    private Integer fkTimetype;

    private Integer fkWorktype;

}