package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.product.bean.Goods;
import com.wc.product.dao.GoodsDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class GoodsDaoImpl extends BaseDao<Long, Goods> implements GoodsDao {

}
