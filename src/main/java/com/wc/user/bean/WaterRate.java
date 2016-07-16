package com.wc.user.bean;

import org.apache.commons.lang.time.DateUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.apache.commons.lang.time.DateUtils.truncatedCompareTo;

public class WaterRate {

    public static final short PAY = 1;
    public static final short NOT_PAY = 0;

    private Long id;

    private BigDecimal total;

    private BigDecimal amount;

    private Date createTime;

    private Long userId;

    private Date payTime;

    private Date month;

    private String mobile;

    private String userName;

    private BigDecimal sewageAmount;
    private BigDecimal resourceAmount;
    private Short status;
    private BigDecimal waterAmount;

    private Long communityId;

    private BigDecimal price;

    private BigDecimal other;

    private String address;

    private String uuid;

    private Boolean overTime;

    private static Date threeDateAgo = DateUtils.addDays(new Date(), -3);

    public Boolean getOverTime() {
        return overTime;
    }

    public void setOverTime(Boolean overTime) {
        this.overTime = overTime;
    }

    //是否超时
    public boolean haveOverTime() {
        return truncatedCompareTo(createTime, threeDateAgo, Calendar.SECOND) < 0;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }


    public BigDecimal getSewageAmount() {
        return sewageAmount;
    }

    public void setSewageAmount(BigDecimal sewageAmount) {
        this.sewageAmount = sewageAmount;
    }

    public BigDecimal getResourceAmount() {
        return resourceAmount;
    }

    public void setResourceAmount(BigDecimal resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(BigDecimal waterAmount) {
        this.waterAmount = waterAmount;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}