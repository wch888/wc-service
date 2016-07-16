package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.WaterRate;

public interface WaterRateDao extends IDao<Long, WaterRate> {


    PagerControl<WaterRate> getPagerWithMember(WaterRate entity, PageInfo pageInfo, String whereSql, String orderBySql);
}