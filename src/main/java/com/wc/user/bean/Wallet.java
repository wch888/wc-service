package com.wc.user.bean;

import java.math.BigDecimal;

public class Wallet {
    private Long id;

    private Long integration = 0L;

    private BigDecimal money = BigDecimal.ZERO;

    private String mobile;

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIntegration() {
        return integration;
    }

    public void setIntegration(Long integration) {
        this.integration = integration;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}