package com.wc.product.service;

import com.wc.product.bean.ProductImage;
import com.wc.product.dao.ProductImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class ProductImageService {

    @Autowired
    private ProductImageDao productImageDao;

    /**
     * 增加用户
     *
     * @param product
     * @return id 主键
     */
    public long add(ProductImage product) {
        productImageDao.insert(product);
        return product.getId();
    }

    public int delete(long id) {
        return productImageDao.delete(id);
    }

    public List<ProductImage> list(long pid) {
        ProductImage query = new ProductImage();
        query.setPid(pid);
        List<ProductImage> list = productImageDao.getListByObj(query, "", "order by id asc");
        return list;
    }


}
