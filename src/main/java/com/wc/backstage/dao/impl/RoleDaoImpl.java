package com.wc.backstage.dao.impl;

import com.wc.backstage.bean.Role;
import com.wc.backstage.dao.RoleDao;
import com.wc.common.db.BaseDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class RoleDaoImpl extends BaseDao<Long, Role> implements RoleDao {

}
