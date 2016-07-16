package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.user.bean.UserImChatRecord;
import com.wc.user.dao.UserImChatRecordDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class UserImChatRecordDaoImpl extends BaseDao<Long, UserImChatRecord> implements UserImChatRecordDao {


    @Override
    public boolean checkIfRecord(String accid, String faccid) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("accid", accid);
        map.put("faccid", faccid);
        map.put("today", new Date().getTime() + "");

        Object obj = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".checkIfRecord", map);
        if (((Integer) obj).intValue() > 0) {
            return true;
        } else {
            return false;
        }
    }


}
