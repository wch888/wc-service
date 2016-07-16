package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.IntegrationLog;
import com.wc.user.dao.IntegrationLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class IntegrationLogService {

    @Autowired
    private IntegrationLogDao integrationLogDao;

    /**
     * 增加用户
     *
     * @param integrationLog
     * @return id 主键
     */
    public long add(IntegrationLog integrationLog) {
        return integrationLogDao.insert(integrationLog);
    }

    public long update(IntegrationLog integrationLog) {
        return integrationLogDao.update(integrationLog);
    }

    public long delete(long id) {
        return integrationLogDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public IntegrationLog getById(long id) {

        return integrationLogDao.getEntityById(id);
    }

    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<IntegrationLog> page(IntegrationLog integrationLog, PageInfo pi, String order) {
        PagerControl<IntegrationLog> pc = integrationLogDao.getPagerByObj(integrationLog, pi, null, order);
        return pc;
    }

    public PagerControl<IntegrationLog> pageWithMember(IntegrationLog integrationLog, PageInfo pi) {
        PagerControl<IntegrationLog> pc = integrationLogDao.pageWithMember(integrationLog, pi, null, "order by i.id desc");
        return pc;
    }
}
