package com.wc.common.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagerControl<T> implements Serializable {
    private List<T> entityList = new ArrayList<T>();
    private PageInfo pageInfo;

    public PagerControl() {
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getEntityList() {
        return this.entityList;
    }

    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

    public String toString() {
        return "PagerControl [entityList=" + this.entityList + ", pageInfo=" + this.pageInfo + "]";
    }
}
