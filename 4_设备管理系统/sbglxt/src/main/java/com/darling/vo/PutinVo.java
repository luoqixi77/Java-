package com.darling.vo;

import com.darling.pojo.Putin;

public class PutinVo extends Putin {
    private Integer page;
    private Integer limit;
    private String beginTime;
    private String endTime;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "PutinVo{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
