package com.wc.backstage.service;

import com.wc.backstage.bean.RoleUserKey;
import com.wc.backstage.dao.RoleUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class RoleUserService {

    @Autowired
    private RoleUserDao roleUserDao;

    /**
     * 增加用户
     *
     * @return id 主键
     */
    public long add(RoleUserKey roleUser) {
        return roleUserDao.insert(roleUser);
    }

    public long deleteAndadd(RoleUserKey roleUser) {
        RoleUserKey delete = new RoleUserKey();
        delete.setUserId(roleUser.getUserId());
        roleUserDao.delete(delete);
        return roleUserDao.insert(roleUser);
    }


    public long update(RoleUserKey roleUser) {
        return roleUserDao.update(roleUser);
    }

    public long delete(RoleUserKey id) {
        return roleUserDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public RoleUserKey getById(RoleUserKey id) {

        return roleUserDao.getEntityById(id);
    }


    public List<RoleUserKey> list(Long roleId) {
        RoleUserKey key = new RoleUserKey();
        key.setRoleId(roleId);
        List<RoleUserKey> list = roleUserDao.getListByObj(key);
        return list;
    }

}
