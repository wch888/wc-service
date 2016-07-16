package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Bespeak;
import com.wc.product.bean.BespeakProduct;
import com.wc.product.bean.FinancingUser;
import com.wc.product.dao.BespeakDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class BespeakDaoImpl extends BaseDao<Long, Bespeak> implements BespeakDao {

    @Override
    public PagerControl<BespeakProduct> getPagerWithProduct(BespeakProduct entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountWithProduct(entity, whereSql);
        if (total1 > 0) {
            list = this.getListWithProduct(entity, pageInfo, whereSql, orderBySql);
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

    public List<FinancingUser> getListWithProduct(BespeakProduct entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfoProduct", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getCountWithProduct(BespeakProduct entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntityProduct", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }
}
