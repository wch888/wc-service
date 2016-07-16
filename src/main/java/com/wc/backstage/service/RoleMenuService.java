package com.wc.backstage.service;

import com.wc.backstage.bean.RoleMenuKey;
import com.wc.backstage.bean.RoleUserKey;
import com.wc.backstage.dao.RoleMenuDao;
import com.wc.backstage.dao.RoleUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RoleUserDao roleUserDao;

    /**
     * 增加用户
     *
     * @return id 主键
     */
    public long add(RoleMenuKey roleMenu) {
        return roleMenuDao.insert(roleMenu);
    }

    public long addRoleMenuKey(RoleMenuKey key) {
        return roleMenuDao.insert(key);
    }

    public long update(RoleMenuKey roleMenu) {
        return roleMenuDao.update(roleMenu);
    }

    public long delete(RoleMenuKey id) {
        return roleMenuDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public RoleMenuKey getById(RoleMenuKey id) {

        return roleMenuDao.getEntityById(id);
    }


    public List<RoleMenuKey> list(Long roleId) {
        RoleMenuKey key = new RoleMenuKey();
        key.setRoleId(roleId);
        List<RoleMenuKey> list = roleMenuDao.getListByObj(key);
        return list;
    }

    public List<RoleMenuKey> listByUserId(Long userId) {

        RoleUserKey key = new RoleUserKey();
        key.setUserId(userId);
        List<RoleUserKey> list = roleUserDao.getListByObj(key);
        if (!list.isEmpty() && list.size() > 0) {
            RoleUserKey roleUser = list.get(0);
            return this.list(roleUser.getRoleId());
        }

        return Collections.EMPTY_LIST;
    }
}
