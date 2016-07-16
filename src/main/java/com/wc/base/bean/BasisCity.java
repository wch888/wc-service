package com.wc.base.bean;

public class BasisCity {
    private Long id;

    private Long cityCode;

    private String cityName;

    private Long cityParent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Long getCityParent() {
        return cityParent;
    }

    public void setCityParent(Long cityParent) {
        this.cityParent = cityParent;
    }
}