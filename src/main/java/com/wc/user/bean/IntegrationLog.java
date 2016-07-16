package com.wc.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class IntegrationLog {
    //兑换商品 积分类型
    public static final String BUY = "buy";
    //全民经纪人
    public static final String CLUE = "clue";
    //注册
    public static final String REG = "reg";
    //分享
    public static final String SHARE = "share";
    //通过业主审核
    public static final String VERIFY = "verify";
    public static final String LOGIN = "login";

    public static final String REG_STR = "注册送积分";
    public static final String BUY_STR = "兑换商品";
    public static final String SHARE_STR = "分享房源";
    public static final String CLUE_STR = "提供有效线索";
    public static final String VERIFY_STR = "通过业主审核";
    public static final String LOGIN_STR = "每日登录送积分";

    private Long id;

    private String title;

    private Date createTime;

    private Integer integration;

    private Long userId;

    private String type;

    private Long pid;

    private String defaultImg;

    private BigDecimal price;

    private String mobile;

    private String nickname;


    /**
     * type 变成中文
     */
    public void buildTypeToChina(){
        if (BUY.equals(type)) {
            type=BUY_STR;
        }
        if (CLUE.equals(type)) {
            type=CLUE_STR;
        }
        if (REG.equals(type)) {
            type=REG_STR;
        }
        if (SHARE.equals(type)) {
            type=SHARE_STR;
        }
        if (VERIFY.equals(type)) {
            type=VERIFY_STR;
        }
        if (LOGIN.equals(type)) {
            type=LOGIN_STR;
        }
    }

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(String defaultImg) {
        this.defaultImg = defaultImg;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}