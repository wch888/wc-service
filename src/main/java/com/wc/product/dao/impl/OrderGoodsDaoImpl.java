package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.product.bean.OrderGoods;
import com.wc.product.dao.OrderGoodsDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class OrderGoodsDaoImpl extends BaseDao<Long, OrderGoods> implements OrderGoodsDao {

}
