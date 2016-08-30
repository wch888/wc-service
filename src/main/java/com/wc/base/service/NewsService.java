package com.wc.base.service;

import com.wc.base.bean.News;
import com.wc.base.dao.NewsDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 */
@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    /**
     * 增加用户
     *
     * @param news
     * @return id 主键
     */
    public long add(News news) {
         newsDao.insert(news);
         return news.getId();
    }

    public int delete(long id) {
        return newsDao.delete(id);
    }

    public long update(News news) {
        newsDao.update(news);
        return news.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public News getById(long id) {
        return newsDao.getEntityById(id);
    }

    public PagerControl<News> page(News news, PageInfo pi) {
        if (null != news && StringUtils.isNotBlank(news.getTitle())) {
            String like = "%" + news.getTitle() + "%";
            news.setTitle(like);
        }
        PagerControl<News> pc = newsDao.getPagerByObj(news, pi, null, "order by id desc");
        return pc;
    }

    public List<News> list(News news, PageInfo pi, String order) {
        List<News> pc = newsDao.getListByObj(news, pi, null, order);
        return pc;
    }

}
