package com.wc.product.bean;

import java.util.Date;

public class Bespeak {

    //  0等待跟进  1跟进中 2交易成功  -2交易失败
    public static final short CREATE = 0;
    public static final short ONGOING = 1;
    public static final short SUCCESS = 2;
    public static final short FAIL = -2;

    private Long id;

    private String name;

    private String mobile;

    private Date createTime;

    private Long userId;

    private Long pid;
    private Long agentId;

    private Short status;

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}