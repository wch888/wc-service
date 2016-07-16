package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Product;
import com.wc.product.dao.ProductDao;
import com.wc.product.dto.ProductQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class ProductDaoImpl extends BaseDao<Long, Product> implements ProductDao {

    @Override
    public PagerControl<Product> getPagerByDto(ProductQuery entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountByDto(entity, whereSql);
        if (total1 > 0) {
            list = this.getListByDto(entity, pageInfo, whereSql, orderBySql);
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

    public List<Product> getListByDto(ProductQuery entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfoDto", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getCountByDto(ProductQuery entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntityDto", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }

    @Override
    public PagerControl<Product> getPagerByBespeak(Product entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountByBespeak(entity, whereSql);
        if (total1 > 0) {
            list = this.getListByBespeak(entity, pageInfo, whereSql, orderBySql);
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

    public List<Product> getListByBespeak(Product entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfoBespeak", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getCountByBespeak(Product entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntityBespeak", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }

}
