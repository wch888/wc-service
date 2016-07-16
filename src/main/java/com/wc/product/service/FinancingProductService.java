package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingProduct;
import com.wc.product.bean.MyFinancingProduct;
import com.wc.product.dao.FinancingProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class FinancingProductService {

    @Autowired
    private FinancingProductDao financingProductDao;

    /**
     * 增加用户
     *
     * @param product
     * @return id 主键
     */
    public long add(FinancingProduct product) {
        return financingProductDao.insert(product);
    }

    public int delete(long id) {
        return financingProductDao.delete(id);
    }

    public long update(FinancingProduct product) {
        financingProductDao.update(product);
        return product.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public FinancingProduct getById(long id) {
        return financingProductDao.getEntityById(id);
    }


    public PagerControl<FinancingProduct> page(FinancingProduct product, PageInfo pi, String order) {
        PagerControl<FinancingProduct> pc = financingProductDao.getPagerByObj(product, pi, null, order);
        return pc;
    }

    /**
     * 我的理财
     *
     * @param product
     * @param pi
     * @param order
     * @return
     */
    public PagerControl<MyFinancingProduct> myPage(FinancingProduct product, PageInfo pi, String order) {
        PagerControl<MyFinancingProduct> pc = financingProductDao.getMyPage(product, pi, null, order);
        return pc;
    }

    public List<FinancingProduct> list(FinancingProduct product, PageInfo pi, String order) {
        List<FinancingProduct> pc = financingProductDao.getListByObj(product, pi, null, order);
        return pc;
    }

}
