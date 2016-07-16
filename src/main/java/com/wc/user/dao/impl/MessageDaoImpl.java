package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.user.bean.Message;
import com.wc.user.dao.MessageDao;
import org.springframework.stereotype.Repository;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class MessageDaoImpl extends BaseDao<Long, Message> implements MessageDao {

}
