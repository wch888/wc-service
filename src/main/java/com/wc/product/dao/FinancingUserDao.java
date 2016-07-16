package com.wc.product.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingUser;

public interface FinancingUserDao extends IDao<Long, FinancingUser> {

    PagerControl<FinancingUser> getPagerWithProduct(FinancingUser entity, PageInfo pageInfo, String whereSql, String orderBySql);
}