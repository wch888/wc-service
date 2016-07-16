package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.OrderGoods;
import com.wc.product.dao.OrderGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class OrderGoodsService {

    @Autowired
    private OrderGoodsDao orderGoodsDao;

    /**
     * 增加用户
     *
     * @param orderGoods
     * @return id 主键
     */
    public long add(OrderGoods orderGoods) {
        return orderGoodsDao.insert(orderGoods);
    }

    public int delete(long id) {
        return orderGoodsDao.delete(id);
    }

    public long update(OrderGoods orderGoods) {
        orderGoodsDao.update(orderGoods);
        return orderGoods.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public OrderGoods getById(long id) {
        return orderGoodsDao.getEntityById(id);
    }


    /**
     * @return
     */
    public PagerControl<OrderGoods> page(OrderGoods orderGoods, PageInfo pi, String order) {
        PagerControl<OrderGoods> pc = orderGoodsDao.getPagerByObj(orderGoods, pi, null, order);
        return pc;
    }


}
