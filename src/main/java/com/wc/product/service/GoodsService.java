package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Goods;
import com.wc.product.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 增加用户
     *
     * @param goods
     * @return id 主键
     */
    public long add(Goods goods) {
        return goodsDao.insert(goods);
    }

    public int delete(long id) {
        return goodsDao.delete(id);
    }

    public long update(Goods goods) {
        goodsDao.update(goods);
        return goods.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Goods getById(long id) {
        return goodsDao.getEntityById(id);
    }


    /**
     * @return
     */
    public PagerControl<Goods> page(Goods goods, PageInfo pi, String order) {
        PagerControl<Goods> pc = goodsDao.getPagerByObj(goods, pi, null, order);
        return pc;
    }


}
