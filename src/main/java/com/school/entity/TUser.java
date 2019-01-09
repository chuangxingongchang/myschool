package com.school.entity;

import lombok.Data;

import java.util.Date;
@Data
public class TUser {
    private Integer id;

    private String pword;

    private String nickname;

    private String truename;

    private String idcard;

    private String phoneno;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getFkSchoolId() {
        return fkSchoolId;
    }

    public void setFkSchoolId(Integer fkSchoolId) {
        this.fkSchoolId = fkSchoolId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getFkIntegralId() {
        return fkIntegralId;
    }

    public void setFkIntegralId(Integer fkIntegralId) {
        this.fkIntegralId = fkIntegralId;
    }
}