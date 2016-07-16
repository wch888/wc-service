package com.wc.product.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.product.bean.ProductImage;
import com.wc.product.dao.ProductImageDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class ProductImageDaoImpl extends BaseDao<Long, ProductImage> implements ProductImageDao {

}
