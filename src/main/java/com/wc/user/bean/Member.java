package com.wc.user.bean;

import java.util.Date;

public class Member {

    public static final short REG = 0;
    public static final short VERIFY = 1;
    public static final short HOUSEHOLD = 2;
    public static final short COMMON_BROKER = 0;
    public static final short OFFICAL_BROKER = 1;

    private Long id;

    private String mobile;

    private String password;

    private String nickname;

    private Date lastdate;

    private String head;

    private String description;

    private String jsessionid;

    private Date createTime;

    private Short type;

    private Short brokerType;

    private String mobileLike;

    private String pushId;

    private Long communityId;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getMobileLike() {
        return mobileLike;
    }

    public void setMobileLike(String mobileLike) {
        this.mobileLike = mobileLike;
    }

    public boolean isHouseHold() {
        if (null != type && HOUSEHOLD == type.shortValue()) {
            return true;
        }
        return false;
    }

    public boolean isOfficalBroker() {
        if (null != brokerType && OFFICAL_BROKER == brokerType.shortValue()) {
            return true;
        }
        return false;
    }

    public Short getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(Short brokerType) {
        this.brokerType = brokerType;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid == null ? null : jsessionid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}