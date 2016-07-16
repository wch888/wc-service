package com.wc.base.service;

import com.wc.base.bean.NewsSubscribe;
import com.wc.base.dao.NewsSubscribeDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class NewsSubscribeService {

    @Autowired
    private NewsSubscribeDao newsSubscribeDao;

    public long add(NewsSubscribe newsSubscribe) {
        List<NewsSubscribe> list = newsSubscribeDao.getListByObj(newsSubscribe);
        if (list.isEmpty()) {
            return newsSubscribeDao.insert(newsSubscribe);
        }
        return -1;
    }

    public int delete(long id) {
        return newsSubscribeDao.delete(id);
    }

    public long update(NewsSubscribe newsSubscribe) {
        newsSubscribeDao.update(newsSubscribe);
        return newsSubscribe.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public NewsSubscribe getById(long id) {
        return newsSubscribeDao.getEntityById(id);
    }

    public PagerControl<NewsSubscribe> page(NewsSubscribe newsSubscribe, PageInfo pi, String order) {
        PagerControl<NewsSubscribe> pc = newsSubscribeDao.getPagerByObj(newsSubscribe, pi, null, order);
        return pc;
    }

    public List<NewsSubscribe> list(NewsSubscribe newsSubscribe, PageInfo pi, String order) {
        List<NewsSubscribe> pc = newsSubscribeDao.getListByObj(newsSubscribe, pi, null, order);
        return pc;
    }

}
