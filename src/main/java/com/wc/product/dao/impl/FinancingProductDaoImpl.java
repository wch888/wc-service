package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingProduct;
import com.wc.product.bean.MyFinancingProduct;
import com.wc.product.dao.FinancingProductDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class FinancingProductDaoImpl extends BaseDao<Long, FinancingProduct> implements FinancingProductDao {

    @Override
    public PagerControl<MyFinancingProduct> getMyPage(FinancingProduct entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getMyTotalByEntity(entity, whereSql);
        if (total1 > 0) {
            list = this.getMyListByEntityAndPageInfo(entity, pageInfo, whereSql, orderBySql);
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

    public List<MyFinancingProduct> getMyListByEntityAndPageInfo(FinancingProduct entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getMyListByEntityAndPageInfo", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getMyTotalByEntity(FinancingProduct entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getMyTotalByEntity", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }
}
