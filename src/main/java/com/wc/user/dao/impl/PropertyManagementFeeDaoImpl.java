package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingUser;
import com.wc.user.bean.PropertyManagementFee;
import com.wc.user.dao.PropertyManagementFeeDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class PropertyManagementFeeDaoImpl extends BaseDao<Long, PropertyManagementFee> implements PropertyManagementFeeDao {

    @Override
    public PagerControl<PropertyManagementFee> pageWithMember(PropertyManagementFee entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountWithMember(entity, whereSql);
        if (total1 > 0) {
            list = this.getListWithMember(entity, pageInfo, whereSql, orderBySql);
        }
        if (null != pageInfo) {
            pageInfo.setTotalCounts(total1);
        }
        if (list != null) {
            pagerControl.setEntityList((List) list);
        }

        pagerControl.setPageInfo(pageInfo);
        return pagerControl;
    }

    public List<FinancingUser> getListWithMember(PropertyManagementFee entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfoMember", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getCountWithMember(PropertyManagementFee entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntityMember", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }
}
