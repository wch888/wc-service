package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.product.bean.ProductType;
import com.wc.product.dao.ProductTypeDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class ProductTypeDaoImpl extends BaseDao<Long, ProductType> implements ProductTypeDao {

}
