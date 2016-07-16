package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.LuckyMoneyLog;

public interface LuckyMoneyLogDao extends IDao<Long, LuckyMoneyLog> {


    PagerControl<LuckyMoneyLog> pageWithMember(LuckyMoneyLog entity, PageInfo pageInfo, String whereSql, String orderBySql);
}