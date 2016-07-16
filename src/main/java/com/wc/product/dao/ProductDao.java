package com.wc.product.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Product;
import com.wc.product.dto.ProductQuery;

public interface ProductDao extends IDao<Long, Product> {


    PagerControl<Product> getPagerByDto(ProductQuery entity, PageInfo pageInfo, String whereSql, String orderBySql);

    PagerControl<Product> getPagerByBespeak(Product entity, PageInfo pageInfo, String whereSql, String orderBySql);
}