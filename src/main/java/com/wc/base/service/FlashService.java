package com.wc.base.service;

import com.wc.base.bean.Flash;
import com.wc.base.dao.FlashDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 */
@Service
public class FlashService {

    //缓存
    private static Map<Long, List<Flash>> cache = new LinkedHashMap();

    @Autowired
    private FlashDao flashDao;

    /**
     * 增加用户
     *
     * @param flash
     * @return id 主键
     */
    public void add(Flash flash) {
        flashDao.insert(flash);
    }

    public int delete(long id) {
        return flashDao.delete(id);
    }

    public long update(Flash news) {
        flashDao.update(news);
        return news.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Flash getById(long id) {
        return flashDao.getEntityById(id);
    }


    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Flash> page(Flash news, PageInfo pi, String order) {
        PagerControl<Flash> pc = flashDao.getPagerByObj(news, pi, null, order);
        return pc;
    }

    public List<Flash> getAll(Flash flash) {
        String order = "order by id desc";
        List<Flash> pc = flashDao.getListByObj(flash, "", order);
        return pc;
    }

}
