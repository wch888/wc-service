package com.wc.base.service;

import com.wc.base.bean.Nav;
import com.wc.base.dao.NavDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class NavService {

    //缓存
    private static Map<Long, List<Nav>> cache = new LinkedHashMap();

    @Autowired
    private NavDao navDao;

    /**
     * 增加用户
     *
     * @param nav
     * @return id 主键
     */
    public int add(Nav nav) {
        return navDao.insert(nav);
    }

    public int delete(long id) {
        return navDao.delete(id);
    }

    public long update(Nav news) {
        navDao.update(news);
        return news.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Nav getById(long id) {
        return navDao.getEntityById(id);
    }


    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Nav> page(Nav news, PageInfo pi, String order) {
        if (null != news && StringUtils.isNotBlank(news.getTitle())) {
            String like = "%" + news.getTitle() + "%";
            news.setTitle(like);
        }
        PagerControl<Nav> pc = navDao.getPagerByObj(news, pi, null, order);
        return pc;
    }

    public List<Nav> getAll(Nav nav) {
        String order = "order by id desc";
        List<Nav> pc = navDao.getListByObj(nav, "", order);
        return pc;
    }


}
