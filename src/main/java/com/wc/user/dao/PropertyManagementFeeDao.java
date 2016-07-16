package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.PropertyManagementFee;

public interface PropertyManagementFeeDao extends IDao<Long, PropertyManagementFee> {


    PagerControl<PropertyManagementFee> pageWithMember(PropertyManagementFee entity, PageInfo pageInfo, String whereSql, String orderBySql);
}