package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.IntegrationLog;

public interface IntegrationLogDao extends IDao<Long, IntegrationLog> {


    PagerControl<IntegrationLog> pageWithMember(IntegrationLog wallet, PageInfo pageInfo, String whereSql, String orderBySql);
}