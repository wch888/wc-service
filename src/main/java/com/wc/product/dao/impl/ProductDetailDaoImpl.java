package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.product.bean.ProductDetail;
import com.wc.product.dao.ProductDetailDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class ProductDetailDaoImpl extends BaseDao<Long, ProductDetail> implements ProductDetailDao {

}
