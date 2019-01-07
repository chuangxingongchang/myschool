package com.school.entity;

public class TSignup {
    private Integer id;

    private Integer pkPlurid;

    private Integer pkUid;

    private String signstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPkPlurid() {
        return pkPlurid;
    }

    public void setPkPlurid(Integer pkPlurid) {
        this.pkPlurid = pkPlurid;
    }

    public Integer getPkUid() {
        return pkUid;
    }

    public void setPkUid(Integer pkUid) {
        this.pkUid = pkUid;
    }

    public String getSignstate() {
        return signstate;
    }

    public void setSignstate(String signstate) {
        this.signstate = signstate == null ? null : signstate.trim();
    }
}