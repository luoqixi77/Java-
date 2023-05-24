package com.darling.pojo;

public class Putin {
    // putin表的字段
    private String pno;
    private String mid;
    private Integer paccount;
    private Float pprice;
    private String pdate;
    private String pagent;
    private String psource;
    private String pnote;

    // 关联material表的字段
    private String mname;
    private String mpic;
    private String mkid;
    private String munit;
    private String mspec;

    // 关联kind表
    private String kname;

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getPaccount() {
        return paccount;
    }

    public void setPaccount(Integer paccount) {
        this.paccount = paccount;
    }

    public Float getPprice() {
        return pprice;
    }

    public void setPprice(Float pprice) {
        this.pprice = pprice;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPagent() {
        return pagent;
    }

    public void setPagent(String pagent) {
        this.pagent = pagent;
    }

    public String getPsource() {
        return psource;
    }

    public void setPsource(String psource) {
        this.psource = psource;
    }

    public String getPnote() {
        return pnote;
    }

    public void setPnote(String pnote) {
        this.pnote = pnote;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpic() {
        return mpic;
    }

    public void setMpic(String mpic) {
        this.mpic = mpic;
    }

    public String getMkid() {
        return mkid;
    }

    public void setMkid(String mkid) {
        this.mkid = mkid;
    }

    public String getMunit() {
        return munit;
    }

    public void setMunit(String munit) {
        this.munit = munit;
    }

    public String getMspec() {
        return mspec;
    }

    public void setMspec(String mspec) {
        this.mspec = mspec;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    @Override
    public String toString() {
        return "Putin{" +
                "pno='" + pno + '\'' +
                ", mid='" + mid + '\'' +
                ", paccount=" + paccount +
                ", pprice=" + pprice +
                ", pdate='" + pdate + '\'' +
                ", pagent='" + pagent + '\'' +
                ", psource='" + psource + '\'' +
                ", pnote='" + pnote + '\'' +
                ", mname='" + mname + '\'' +
                ", mpic='" + mpic + '\'' +
                ", mkid='" + mkid + '\'' +
                ", munit='" + munit + '\'' +
                ", mspec='" + mspec + '\'' +
                ", kname='" + kname + '\'' +
                '}';
    }
}
