package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.WaterRate;
import com.wc.user.dao.WaterRateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class WaterRateService {

    @Autowired
    private WaterRateDao waterRateDao;

    /**
     * 增加用户
     *
     * @param message
     * @return id 主键
     */
    public long add(WaterRate message) {
        return waterRateDao.insert(message);
    }

    public long update(WaterRate message) {
        waterRateDao.update(message);
        return message.getId();
    }

    public void addOrUpdate(List<WaterRate> list) {
        for (WaterRate waterRate : list) {
            WaterRate query = new WaterRate();
            query.setUuid(waterRate.getUuid());
            WaterRate result = waterRateDao.getEntityByObj(query);
            if (null==result){
                waterRateDao.insert(waterRate);
            }else {
                waterRate.setId(result.getId());
                waterRateDao.update(waterRate);
            }
        }

    }

    public long delete(long id) {
        return waterRateDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public WaterRate getById(long id) {

        return waterRateDao.getEntityById(id);
    }

    /**
     *
     * @return
     */
    public PagerControl<WaterRate> page(WaterRate bean, PageInfo pi, String order) {
        PagerControl<WaterRate> pc = waterRateDao.getPagerByObj(bean, pi, null, order);
        return pc;
    }

    /**
     * 分页关联出用户
     *
     * @param bean
     * @param pi
     * @param order
     * @return
     */
    public PagerControl<WaterRate> pageWithMember(WaterRate bean, PageInfo pi, String order) {
        PagerControl<WaterRate> pc = waterRateDao.getPagerWithMember(bean, pi, null, order);
        return pc;
    }
}
