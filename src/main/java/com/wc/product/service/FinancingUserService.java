package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.FinancingUser;
import com.wc.product.dao.FinancingUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class FinancingUserService {

    @Autowired
    private FinancingUserDao financingUserDao;

    /**
     * 增加用户
     *
     * @param product
     * @return id 主键
     */
    public int add(FinancingUser product) {
        return financingUserDao.insert(product);
    }

    public int delete(long id) {
        return financingUserDao.delete(id);
    }

    public long update(FinancingUser product) {
        financingUserDao.update(product);
        return product.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public FinancingUser getById(long id) {
        return financingUserDao.getEntityById(id);
    }

    public PagerControl<FinancingUser> page(FinancingUser product, PageInfo pi, String order) {
        PagerControl<FinancingUser> pc = financingUserDao.getPagerByObj(product, pi, null, order);
        return pc;
    }

    public PagerControl<FinancingUser> pageWithProduct(FinancingUser product, PageInfo pi, String order) {
        PagerControl<FinancingUser> pc = financingUserDao.getPagerWithProduct(product, pi, null, order);
        return pc;
    }
}
