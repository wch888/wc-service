package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.user.bean.Customer;
import com.wc.user.dao.CustomerDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2013-08-29.
 */
@Repository
public class CustomerDaoImpl extends BaseDao<Long, Customer> implements CustomerDao {

}
