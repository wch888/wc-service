package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.PropertyManagementFee;
import com.wc.user.dao.PropertyManagementFeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class PropertyManagementFeeService {

    @Autowired
    private PropertyManagementFeeDao propertyManagementFeeDao;

    /**
     * 增加用户
     *
     * @param message
     * @return id 主键
     */
    public long add(PropertyManagementFee message) {
        return propertyManagementFeeDao.insert(message);
    }

    public long update(PropertyManagementFee message) {
        propertyManagementFeeDao.update(message);
        return message.getId();
    }

    public long delete(long id) {
        return propertyManagementFeeDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public PropertyManagementFee getById(long id) {

        return propertyManagementFeeDao.getEntityById(id);
    }

    public PagerControl<PropertyManagementFee> page(PropertyManagementFee memeber, PageInfo pi, String order) {
        PagerControl<PropertyManagementFee> pc = propertyManagementFeeDao.getPagerByObj(memeber, pi, null, order);
        return pc;
    }

    public PagerControl<PropertyManagementFee> pageWithMember(PropertyManagementFee memeber, PageInfo pi, String order) {
        PagerControl<PropertyManagementFee> pc = propertyManagementFeeDao.pageWithMember(memeber, pi, null, order);
        return pc;
    }
}
