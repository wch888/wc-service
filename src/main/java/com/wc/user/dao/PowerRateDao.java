package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.PowerRate;

public interface PowerRateDao extends IDao<Long, PowerRate> {


    PagerControl<PowerRate> getPagerWithMember(PowerRate entity, PageInfo pageInfo, String whereSql, String orderBySql);
}