package com.wc.base.dao.impl;

import com.wc.base.bean.News;
import com.wc.base.dao.NewsDao;
import com.wc.common.db.BaseDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2015-08-29.
 */
@Repository
public class NewsDaoImpl extends BaseDao<Long, News> implements NewsDao {

}
