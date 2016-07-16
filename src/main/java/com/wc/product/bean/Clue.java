package com.wc.product.bean;

import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

import static org.apache.commons.lang.time.DateUtils.truncatedCompareTo;

public class Clue {
    //  0等待跟进  1跟进中 2交易成功 -1线索无效 -2交易失败
    public static final short CREATE = 0;
    public static final short ONGOING = 1;
    public static final short SUCCESS = 2;
    public static final short INVALID = -1;
    public static final short FAIL = -2;

    private Long id;

    private String name;

    private String mobile;

    private Date createTime;

    private Long userId;

    private Long pid;

    private String content;

    private Short status;

    private String tip;

    private Long agentId;

    private String agentName;

    //是否超时
    private Boolean overTime;

    private String userName;


    private static Date threeDateAgo=DateUtils.addDays(new Date(),-3);

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //是否超时
    public boolean haveOverTime() {
        return truncatedCompareTo(createTime,threeDateAgo, Calendar.SECOND)<0;
    }

    public Boolean getOverTime() {
        return overTime;
    }

    public void setOverTime(Boolean overTime) {
        this.overTime = overTime;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public static void main(String[] args) {
        Date threeDateAgo=DateUtils.addDays(new Date(),3);
        int result = DateUtils.truncatedCompareTo(new Date(),threeDateAgo, Calendar.SECOND);
        System.out.println(result);
    }
}