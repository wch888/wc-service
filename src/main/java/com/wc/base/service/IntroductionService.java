package com.wc.base.service;

import com.wc.base.bean.Introduction;
import com.wc.base.dao.IntroductionDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class IntroductionService {

    @Autowired
    private IntroductionDao introductionDao;

    /**
     * 增加用户
     *
     * @param introduction
     * @return id 主键
     */
    public long add(Introduction introduction) {
        introductionDao.insert(introduction);
        return introduction.getId();
    }

    public int delete(long id) {
        return introductionDao.delete(id);
    }

    public long update(Introduction news) {
        introductionDao.update(news);
        return news.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Introduction getById(long id) {
        return introductionDao.getEntityById(id);
    }


    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Introduction> page(Introduction news, PageInfo pi, String order) {
        if (null != news && StringUtils.isNotBlank(news.getTitle())) {
            String like = "%" + news.getTitle() + "%";
            news.setTitle(like);
        }
        PagerControl<Introduction> pc = introductionDao.getPagerByObj(news, pi, null, order);
        return pc;
    }
}
