package com.wc.base.dao.impl;

import com.wc.base.bean.Price;
import com.wc.base.dao.PriceDao;
import com.wc.common.db.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class PriceDaoImpl extends BaseDao<Long, Price> implements PriceDao {

}