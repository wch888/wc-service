package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.LuckyMoney;
import com.wc.user.bean.LuckyMoneyProduct;

public interface LuckyMoneyDao extends IDao<Long, LuckyMoney> {


    PagerControl<LuckyMoneyProduct> getPagerWithProduct(LuckyMoneyProduct entity, PageInfo pageInfo, String whereSql, String orderBySql);
}