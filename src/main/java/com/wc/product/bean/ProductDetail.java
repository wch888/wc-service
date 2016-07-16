package com.wc.product.bean;

public class ProductDetail {
    private Long id;

    private String company;

    private String decorate;

    private String houseCount;

    private String plotRatio;

    private String greeningRate;

    private String parkingSpace;

    private String video;

    private String age;

    private String video360;

    public String getVideo360() {
        return video360;
    }

    public void setVideo360(String video360) {
        this.video360 = video360;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDecorate() {
        return decorate;
    }

    public void setDecorate(String decorate) {
        this.decorate = decorate == null ? null : decorate.trim();
    }

    public String getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(String houseCount) {
        this.houseCount = houseCount == null ? null : houseCount.trim();
    }

    public String getPlotRatio() {
        return plotRatio;
    }

    public void setPlotRatio(String plotRatio) {
        this.plotRatio = plotRatio == null ? null : plotRatio.trim();
    }

    public String getGreeningRate() {
        return greeningRate;
    }

    public void setGreeningRate(String greeningRate) {
        this.greeningRate = greeningRate == null ? null : greeningRate.trim();
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace == null ? null : parkingSpace.trim();
    }
}