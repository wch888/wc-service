package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.user.bean.MemberDetail;
import com.wc.user.dao.MemberDetailDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class MemberDetailDaoImpl extends BaseDao<Long, MemberDetail> implements MemberDetailDao {

}
