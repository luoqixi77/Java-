package com.darling.pojo;

public class Requisition {
    private String rid;
    private String mid;
    private String rstatus;
    private Integer rnum;
    private String rverifier;
    private String rtype;
    private String rapplytime;
    private String rtaketime;
    private String ragent;
    private String rtaker;

    private String mname;

    private String utel;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

    public String getRverifier() {
        return rverifier;
    }

    public void setRverifier(String rverifier) {
        this.rverifier = rverifier;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRapplytime() {
        return rapplytime;
    }

    public void setRapplytime(String rapplytime) {
        this.rapplytime = rapplytime;
    }

    public String getRtaketime() {
        return rtaketime;
    }

    public void setRtaketime(String rtaketime) {
        this.rtaketime = rtaketime;
    }

    public String getRagent() {
        return ragent;
    }

    public void setRagent(String ragent) {
        this.ragent = ragent;
    }

    public String getRtaker() {
        return rtaker;
    }

    public void setRtaker(String rtaker) {
        this.rtaker = rtaker;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    @Override
    public String toString() {
        return "Requisition{" +
                "rid='" + rid + '\'' +
                ", mid='" + mid + '\'' +
                ", rstatus='" + rstatus + '\'' +
                ", rnum=" + rnum +
                ", rverifier='" + rverifier + '\'' +
                ", rtype='" + rtype + '\'' +
                ", rapplytime='" + rapplytime + '\'' +
                ", rtaketime='" + rtaketime + '\'' +
                ", ragent='" + ragent + '\'' +
                ", rtaker='" + rtaker + '\'' +
                ", mname='" + mname + '\'' +
                ", utel='" + utel + '\'' +
                '}';
    }
}
