package com.darling.pojo;

public class Store {
    private String mid;
    private Integer total;

    private String mname;
    private String munit;
    private String mspec;

    public Store(){

    }

    public Store(String mid, Integer total) {
        this.mid = mid;
        this.total = total;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
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

    @Override
    public String toString() {
        return "Store{" +
                "mid='" + mid + '\'' +
                ", total=" + total +
                ", mname='" + mname + '\'' +
                ", munit='" + munit + '\'' +
                ", mspec='" + mspec + '\'' +
                '}';
    }
}
