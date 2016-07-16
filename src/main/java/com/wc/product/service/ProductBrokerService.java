package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.ProductBroker;
import com.wc.product.bean.ProductBrokerKey;
import com.wc.product.dao.ProductBrokerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class ProductBrokerService {

    @Autowired
    private ProductBrokerDao productBrokerDao;

    /**
     * 增加用户
     *
     * @param productBroker
     * @return id 主键
     */
    public long add(ProductBroker productBroker) {
        ProductBroker key = new ProductBroker();
        key.setUserId(productBroker.getUserId());
        key.setPid(productBroker.getPid());
        ProductBroker bean = productBrokerDao.getEntityByObj(key);
        if (null != bean) {
            return -1;
        }
        return productBrokerDao.insert(productBroker);
    }

    public int delete(ProductBrokerKey id) {
        return productBrokerDao.delete(id);
    }

    public void update(ProductBroker productBroker) {
        productBrokerDao.update(productBroker);
    }

    public List<ProductBroker> list(ProductBroker productBroker) {
        return productBrokerDao.getListByObj(productBroker);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public ProductBroker getById(ProductBrokerKey id) {
        return productBrokerDao.getEntityById(id);
    }

    /**
     * 获取之后指针向后移动
     *
     * @return
     */
    public ProductBroker updateAndGetCircleBespeak(long pid) {
        ProductBroker broker = new ProductBroker();
        broker.setPid(pid);

        List<ProductBroker> list = productBrokerDao.getListByObj(broker, "", "order by user_id asc");
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        ProductBroker here = null;
        boolean hasPoint = false;
        for (int i = 0; i < list.size(); i++) {
            here = list.get(i);
            if (here.getBespeakPoint() != null && ProductBroker.POINT == here.getBespeakPoint().shortValue()) {
                hasPoint = true;
                here.setBespeakPoint(ProductBroker.NOT_POINT);
                productBrokerDao.update(here);
                if (i < list.size() - 1) {
                    //更新后面一个
                    ProductBroker next = list.get(i + 1);
                    next.setBespeakPoint(ProductBroker.POINT);
                    productBrokerDao.update(next);
                } else {
                    ProductBroker first = list.get(0);
                    first.setBespeakPoint(ProductBroker.POINT);
                    //更新第一个
                    productBrokerDao.update(first);
                }

                return here;

            }
        }
        if (!hasPoint) {
            here = list.get(0);
            here.setBespeakPoint(ProductBroker.POINT);
            //更新第一个
            productBrokerDao.update(here);
        }
        return here;
    }

    /**
     * 获取之后指针向后移动
     *
     * @return
     */
    public ProductBroker updateAndGetCircleMessage(long pid) {
        ProductBroker broker = new ProductBroker();
        broker.setPid(pid);

        List<ProductBroker> list = productBrokerDao.getListByObj(broker, "", "order by user_id asc");
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        ProductBroker here = null;
        boolean hasPoint = false;
        for (int i = 0; i < list.size(); i++) {
            here = list.get(i);
            if (here.getMessagePoint() != null && ProductBroker.POINT == here.getMessagePoint().shortValue()) {
                hasPoint = true;
                here.setMessagePoint(ProductBroker.NOT_POINT);
                productBrokerDao.update(here);
                if (i < list.size() - 1) {
                    //更新后面一个
                    ProductBroker next = list.get(i + 1);
                    next.setMessagePoint(ProductBroker.POINT);
                    productBrokerDao.update(next);
                } else {
                    ProductBroker first = list.get(0);
                    first.setMessagePoint(ProductBroker.POINT);
                    //更新第一个
                    productBrokerDao.update(first);
                }

                return here;

            }
        }
        if (!hasPoint) {
            here = list.get(0);
            here.setMessagePoint(ProductBroker.POINT);
            //更新第一个
            productBrokerDao.update(here);
        }
        return here;
    }
    /**
     * @return
     */
    public PagerControl<ProductBroker> page(ProductBroker productBroker, PageInfo pi, String order) {
        PagerControl<ProductBroker> pc = productBrokerDao.getPagerByObj(productBroker, pi, null, order);
        return pc;
    }

    /**
     * @return
     */
    public int count(ProductBroker productBroker) {
        int count = productBrokerDao.getCountByObj(productBroker);
        return count;
    }

}
