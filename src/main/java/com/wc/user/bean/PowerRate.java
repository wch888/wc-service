package com.wc.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PowerRate {

    public static final short PAY = 1;
    public static final short NOT_PAY = 0;

    private Long id;

    private BigDecimal total;

    private BigDecimal amount;

    private Date createTime;

    private Long userId;

    private String userName;

    private Date payTime;

    private BigDecimal level1;

    private BigDecimal level2;

    private Short status;

    private Long communityId;

    private Date month;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public BigDecimal getLevel1() {
        return level1;
    }

    public void setLevel1(BigDecimal level1) {
        this.level1 = level1;
    }

    public BigDecimal getLevel2() {
        return level2;
    }

    public void setLevel2(BigDecimal level2) {
        this.level2 = level2;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
}