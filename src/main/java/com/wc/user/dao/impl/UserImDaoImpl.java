package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.user.bean.UserIm;
import com.wc.user.dao.UserImDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class UserImDaoImpl extends BaseDao<Long, UserIm> implements UserImDao {

    @Override
    public boolean checkIfRegister(String userId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        int count = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".checkIfRegister", map);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserIm getUserImByUserId(String userId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        return this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getUserImByUserId", map);
    }

    @Override
    public List<UserIm> getPayedUsers(String userId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("payend", Long.toString(System.currentTimeMillis()));
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getPayedUsers", map);
    }

    @Override
    public void updateByAccid(UserIm userIm) {
        this.getSqlSession().update(this.getMapperNameSpace() + ".updateByAccid", userIm);
    }

    @Override
    public List<UserIm> getFriends(String userId) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        map.put("payend", Long.toString(System.currentTimeMillis()));
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getFriends", map);
    }

}
