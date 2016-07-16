package com.wc.backstage.service;

import com.wc.backstage.bean.Role;
import com.wc.backstage.bean.RoleUserKey;
import com.wc.backstage.dao.RoleDao;
import com.wc.backstage.dao.RoleUserDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleUserDao roleUserDao;

    /**
     * 增加用户
     *
     * @param role
     * @return id 主键
     */
    public long add(Role role) {
        return roleDao.insert(role);
    }

    public long update(Role role) {
        return roleDao.update(role);
    }

    public long delete(long id) {
        return roleDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Role getById(long id) {

        return roleDao.getEntityById(id);
    }

    public Role getByUserId(long userId) {
        RoleUserKey query = new RoleUserKey();
        query.setUserId(userId);
        List<RoleUserKey> list = roleUserDao.getListByObj(query);
        if (!list.isEmpty() && list.size() > 0) {
            RoleUserKey result = list.get(0);
            if (null != result) {
                return roleDao.getEntityById(result.getRoleId());
            }
        }
        return null;
    }

    public List<Role> list(Role role, String order) {
        List<Role> pc = roleDao.getListByObj(role, null, null, order);
        return pc;
    }

    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Role> page(Role role, PageInfo pi, String order) {
        PagerControl<Role> pc = roleDao.getPagerByObj(role, pi, null, order);
        return pc;
    }

}
