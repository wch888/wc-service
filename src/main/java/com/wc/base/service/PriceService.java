package com.wc.base.service;

import com.wc.base.bean.Price;
import com.wc.base.dao.PriceDao;
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
public class PriceService {

    //缓存
    private static Map<Long, List<Price>> cache = new LinkedHashMap();

    @Autowired
    private PriceDao priceDao;

    /**
     * 增加用户
     *
     * @param price
     * @return id 主键
     */
    public void add(Price price) {
        cache.clear();
        priceDao.insert(price);
    }

    public int delete(long id) {
        cache.clear();
        return priceDao.delete(id);
    }

    public long update(Price news) {
        cache.clear();
        priceDao.update(news);
        return news.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Price getById(long id) {
        return priceDao.getEntityById(id);
    }


    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Price> page(Price news, PageInfo pi, String order) {
        PagerControl<Price> pc = priceDao.getPagerByObj(news, pi, null, order);
        return pc;
    }

    public List<Price> list(Price price) {
        if (null != price.getCityId() && price.getCityId() > 0) {
            List<Price> list = cache.get(price.getCityId());
            if (null != list) {
                return list;
            }
        }
        String order = "order by id asc";
        List<Price> pc = priceDao.getListByObj(price, "", order);
        if (!pc.isEmpty()) {
            cache.put(price.getCityId(), pc);
        }
        return pc;
    }

}
