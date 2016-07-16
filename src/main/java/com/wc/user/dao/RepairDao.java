package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Repair;

public interface RepairDao extends IDao<Long, Repair> {


    PagerControl<Repair> pageWithMember(Repair entity, PageInfo pageInfo, String whereSql, String orderBySql);
}