package com.wc.product.bean;

import java.io.Serializable;

public class ProductBrokerKey implements Serializable {
    private Long pid;

    private Long userId;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}