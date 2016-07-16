package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingUser;
import com.wc.user.bean.LuckyMoney;
import com.wc.user.bean.LuckyMoneyProduct;
import com.wc.user.dao.LuckyMoneyDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class LuckyMoneyDaoImpl extends BaseDao<Long, LuckyMoney> implements LuckyMoneyDao {

    @Override
    public PagerControl<LuckyMoneyProduct> getPagerWithProduct(LuckyMoneyProduct entity, PageInfo pageInfo, String whereSql, String orderBySql) {
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

    public List<FinancingUser> getListWithProduct(LuckyMoneyProduct entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfoProduct", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getCountWithProduct(LuckyMoneyProduct entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntityProduct", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }
}
