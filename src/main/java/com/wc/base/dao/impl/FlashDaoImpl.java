package com.wc.base.dao.impl;

import com.wc.base.bean.Flash;
import com.wc.base.dao.FlashDao;
import com.wc.common.db.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class FlashDaoImpl extends BaseDao<Long, Flash> implements FlashDao {

}