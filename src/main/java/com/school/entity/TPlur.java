package com.school.entity;

import java.util.Date;

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

    private Integer fkSchool;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getFkUnit() {
        return fkUnit;
    }

    public void setFkUnit(Integer fkUnit) {
        this.fkUnit = fkUnit;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    public String getSettlemethod() {
        return settlemethod;
    }

    public void setSettlemethod(String settlemethod) {
        this.settlemethod = settlemethod == null ? null : settlemethod.trim();
    }

    public String getWordtime() {
        return wordtime;
    }

    public void setWordtime(String wordtime) {
        this.wordtime = wordtime == null ? null : wordtime.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getWorkcontent() {
        return workcontent;
    }

    public void setWorkcontent(String workcontent) {
        this.workcontent = workcontent == null ? null : workcontent.trim();
    }

    public Integer getFkPublisher() {
        return fkPublisher;
    }

    public void setFkPublisher(Integer fkPublisher) {
        this.fkPublisher = fkPublisher;
    }

    public Integer getFkAccept() {
        return fkAccept;
    }

    public void setFkAccept(Integer fkAccept) {
        this.fkAccept = fkAccept;
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress == null ? null : workaddress.trim();
    }

    public Integer getFkWorkicon() {
        return fkWorkicon;
    }

    public void setFkWorkicon(Integer fkWorkicon) {
        this.fkWorkicon = fkWorkicon;
    }

    public Integer getFkWorkstate() {
        return fkWorkstate;
    }

    public void setFkWorkstate(Integer fkWorkstate) {
        this.fkWorkstate = fkWorkstate;
    }

    public Integer getFkLocationtype() {
        return fkLocationtype;
    }

    public void setFkLocationtype(Integer fkLocationtype) {
        this.fkLocationtype = fkLocationtype;
    }

    public Integer getFkTimetype() {
        return fkTimetype;
    }

    public void setFkTimetype(Integer fkTimetype) {
        this.fkTimetype = fkTimetype;
    }

    public Integer getFkWorktype() {
        return fkWorktype;
    }

    public void setFkWorktype(Integer fkWorktype) {
        this.fkWorktype = fkWorktype;
    }

    public Integer getFkSchool() {
        return fkSchool;
    }

    public void setFkSchool(Integer fkSchool) {
        this.fkSchool = fkSchool;
    }
}