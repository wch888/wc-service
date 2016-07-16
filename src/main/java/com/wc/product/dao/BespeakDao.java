package com.wc.product.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Bespeak;
import com.wc.product.bean.BespeakProduct;

public interface BespeakDao extends IDao<Long, Bespeak> {


    PagerControl<BespeakProduct> getPagerWithProduct(BespeakProduct entity, PageInfo pageInfo, String whereSql, String orderBySql);
}