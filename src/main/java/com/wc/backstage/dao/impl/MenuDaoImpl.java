package com.wc.backstage.dao.impl;

import com.wc.backstage.bean.Menu;
import com.wc.backstage.dao.MenuDao;
import com.wc.common.db.BaseDao;
import org.springframework.stereotype.Repository;



@Repository
public class MenuDaoImpl extends BaseDao<Long, Menu> implements MenuDao {

}
