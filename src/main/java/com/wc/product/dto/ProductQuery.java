package com.wc.product.dto;

import com.wc.product.bean.Product;

import java.math.BigDecimal;

/**
 * Created by ruby on 2014-03-31.
 */
public class ProductQuery extends Product {

    private BigDecimal priceMin;
    private BigDecimal priceMax;
    private Integer houseType;

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceMin = priceMin;
    }

    public BigDecimal getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(BigDecimal priceMax) {
        this.priceMax = priceMax;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }
}
