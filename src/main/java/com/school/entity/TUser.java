package com.school.entity;

import lombok.Data;

import java.util.Date;
@Data
public class TUser {
    private Integer id;

    private String uname;

    private String pword;

    private String nickname;

    private String truename;

    private String idcard;

    private String phoneno;

    private String email;

    private Date brithday;

    private String sex;

    private String address;

    private String avatar;

    private Integer credit;

    private Integer fkSchoolId;

    private Date createtime;

    private Double balance;

    private Integer integral;

    private Integer fkIntegralId;
    }

