package com.wc.base.dao.impl;

import com.wc.base.bean.Nav;
import com.wc.base.dao.NavDao;
import com.wc.common.db.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class NavDaoImpl extends BaseDao<Long, Nav> implements NavDao {

}