package com.darling.pojo;

public class Material {
    private String mid;
    private String mname;
    private String mpic;
    private String mkid;
    private String munit;
    private String mspec;

    private String kname;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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
        return "Material{" +
                "mid='" + mid + '\'' +
                ", mname='" + mname + '\'' +
                ", mpic='" + mpic + '\'' +
                ", mkid='" + mkid + '\'' +
                ", munit='" + munit + '\'' +
                ", mspec='" + mspec + '\'' +
                ", kname='" + kname + '\'' +
                '}';
    }
}
