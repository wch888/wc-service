package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Product;
import com.wc.product.bean.ProductDetail;
import com.wc.product.dao.ProductDao;
import com.wc.product.dao.ProductDetailDao;
import com.wc.product.dto.ProductQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductDetailDao productDetailDao;
    /**
     * 增加用户
     *
     * @param product
     * @return id 主键
     */
    public long add(Product product,ProductDetail detail) {
        productDao.insert(product);
        long id =  product.getId();
        detail.setId(id);
        productDetailDao.insert(detail);
        return id;
    }

    public int delete(long id) {
        return productDao.delete(id);
    }

    public long update(Product product) {
        productDao.update(product);
        return product.getId();
    }

    public long update(ProductDetail detail1) {
        ProductDetail detail = getDetailById(detail1.getId());
        if(null==detail){
            return productDetailDao.insert(detail1);
        }else {
            return productDetailDao.update(detail1);
        }
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Product getById(long id) {
        return productDao.getEntityById(id);
    }

    public ProductDetail getDetailById(long id) {
        return productDetailDao.getEntityById(id);
    }


    public PagerControl<Product> page(Product product, PageInfo pi, String order) {
        if (null != product && StringUtils.isNotBlank(product.getName())) {
            String like = "%" + product.getName() + "%";
            product.setName(like);
        }
        PagerControl<Product> pc = productDao.getPagerByObj(product, pi, null, order);
        return pc;
    }

    /**
     * 预约买房列表
     *
     * @param product
     * @param pi
     * @param order
     * @return
     */
    public PagerControl<Product> bespeakPage(Product product, PageInfo pi, String order) {
        if (null != product && StringUtils.isNotBlank(product.getName())) {
            String like = "%" + product.getName() + "%";
            product.setName(like);
        }
        PagerControl<Product> pc = productDao.getPagerByBespeak(product, pi, null, order);
        return pc;
    }


    public PagerControl<Product> pageDto(ProductQuery product, PageInfo pi, String order) {
        if (null != product && StringUtils.isNotBlank(product.getName())) {
            String like = "%" + product.getName() + "%";
            product.setName(like);
        }
        String where = "status in (1,0)";
        if (null != product.getHouseType()) {
            where += "and id in (select pid from product_type where  type=" + product.getHouseType() + ")";
        }
        PagerControl<Product> pc = productDao.getPagerByDto(product, pi, where, order);
        return pc;
    }

    public List<Product> list(Product product, PageInfo pi, String order) {
        List<Product> pc = productDao.getListByObj(product, pi, null, order);
        return pc;
    }
}
