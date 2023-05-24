package com.darling.vo;

import com.darling.pojo.Material;

public class MaterialVo extends Material {
    private Integer page;
    private Integer limit;

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

    @Override
    public String toString() {
        return "MaterialVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", Material=" + super.toString() +
                '}';
    }
}
