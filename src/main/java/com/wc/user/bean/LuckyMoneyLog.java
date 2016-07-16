package com.wc.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class LuckyMoneyLog {

    //有效
    public static final short VALID = 1;
    //已经使用
    public static final short USED = 0;
    //已经过期
    public static final short NOT_VALID = -1;

    private Long id;

    private BigDecimal amount;

    private Date createTime;

    private Long userId;

    private String userName;

    private String code;

    private Short status;

    private Long pid;

    private Long luckyId;

    private String title;

    private Date statTime;

    private Date endTime;

    private String desc="签约后折现";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getStatTime() {
        return statTime;
    }

    public void setStatTime(Date statTime) {
        this.statTime = statTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getLuckyId() {
        return luckyId;
    }

    public void setLuckyId(Long luckyId) {
        this.luckyId = luckyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}