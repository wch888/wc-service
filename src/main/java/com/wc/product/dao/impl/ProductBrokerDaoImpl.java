package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.product.bean.ProductBroker;
import com.wc.product.bean.ProductBrokerKey;
import com.wc.product.dao.ProductBrokerDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class ProductBrokerDaoImpl extends BaseDao<ProductBrokerKey, ProductBroker> implements ProductBrokerDao {

}
