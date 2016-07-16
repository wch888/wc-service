package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.PowerRate;
import com.wc.user.dao.PowerRateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class PowerRateService {

    @Autowired
    private PowerRateDao powerRateDao;

    /**
     * 增加用户
     *
     * @param message
     * @return id 主键
     */
    public long add(PowerRate message) {
        return powerRateDao.insert(message);
    }

    public long update(PowerRate message) {
        powerRateDao.update(message);
        return message.getId();
    }

    public long delete(long id) {
        return powerRateDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public PowerRate getById(long id) {

        return powerRateDao.getEntityById(id);
    }

    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<PowerRate> page(PowerRate bean, PageInfo pi, String order) {
        PagerControl<PowerRate> pc = powerRateDao.getPagerByObj(bean, pi, null, order);
        return pc;
    }

    public PagerControl<PowerRate> pageWithMember(PowerRate bean, PageInfo pi, String order) {
        PagerControl<PowerRate> pc = powerRateDao.getPagerWithMember(bean, pi, null, order);
        return pc;
    }
}
