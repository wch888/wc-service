package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Customer;
import com.wc.user.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 增加用户
     *
     * @param customer
     * @return id 主键
     */
    public long add(Customer customer) {
        return customerDao.insert(customer);
    }

    public long update(Customer customer) {
        return customerDao.update(customer);
    }

    public long delete(long id) {
        return customerDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Customer getById(long id) {

        return customerDao.getEntityById(id);
    }

    public Customer getByMobile(String mobile) {
        Customer customer = new Customer();
        customer.setMobile(mobile);
        return customerDao.getEntityByObj(customer);
    }


    public List<Customer> list(Customer customer, String order) {
        List<Customer> pc = customerDao.getListByObj(customer, null, null, order);
        return pc;
    }

    public PagerControl<Customer> page(Customer customer, PageInfo pi, String order) {
        PagerControl<Customer> pc = customerDao.getPagerByObj(customer, pi, null, order);
        return pc;
    }
}
