package com.wc.product.bean;

public class ProductBroker extends ProductBrokerKey {
    public static final short VALID = 1;
    public static final short POINT = 1;
    public static final short NOT_POINT = 0;
    private Short status;

    private String nickname;

    private Short bespeakPoint;

    private Short messagePoint;

    public Short getMessagePoint() {
        return messagePoint;
    }

    public void setMessagePoint(Short messagePoint) {
        this.messagePoint = messagePoint;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Short getBespeakPoint() {
        return bespeakPoint;
    }

    public void setBespeakPoint(Short bespeakPoint) {
        this.bespeakPoint = bespeakPoint;
    }
}