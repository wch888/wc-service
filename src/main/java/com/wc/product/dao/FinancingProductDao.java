package com.wc.product.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingProduct;
import com.wc.product.bean.MyFinancingProduct;

public interface FinancingProductDao extends IDao<Long, FinancingProduct> {


    PagerControl<MyFinancingProduct> getMyPage(FinancingProduct entity, PageInfo pageInfo, String whereSql, String orderBySql);
}