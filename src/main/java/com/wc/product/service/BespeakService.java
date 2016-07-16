package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Bespeak;
import com.wc.product.bean.BespeakProduct;
import com.wc.product.dao.BespeakDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class BespeakService {

    @Autowired
    private BespeakDao bespeakDao;

    /**
     * 增加用户
     *
     * @param bespeak
     * @return id 主键
     */
    public long add(Bespeak bespeak) {
        return bespeakDao.insert(bespeak);
    }

    public int delete(long id) {
        return bespeakDao.delete(id);
    }

    public long update(Bespeak bespeak) {
        bespeakDao.update(bespeak);
        return bespeak.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Bespeak getById(long id) {
        return bespeakDao.getEntityById(id);
    }

    public int count(Bespeak bespeak) {
        return bespeakDao.getCountByObj(bespeak);
    }
    /**
     * 预约列表
     *
     * @return
     */
    public PagerControl<Bespeak> page(Bespeak bespeak, PageInfo pi, String order) {
        if (null != bespeak && StringUtils.isNotBlank(bespeak.getName())) {
            String like = "%" + bespeak.getName() + "%";
            bespeak.setName(like);
        }
        PagerControl<Bespeak> pc = bespeakDao.getPagerByObj(bespeak, pi, null, order);
        return pc;
    }

    /**
     * 预约列表
     *
     * @return
     */
    public PagerControl<BespeakProduct> pageWithProduct(BespeakProduct bespeak, PageInfo pi, String order) {
        if (null != bespeak && StringUtils.isNotBlank(bespeak.getTitle())) {
            String like = "%" + bespeak.getTitle() + "%";
            bespeak.setTitle(like);
        }
        PagerControl<BespeakProduct> pc = bespeakDao.getPagerWithProduct(bespeak, pi, null, order);
        return pc;
    }
}
