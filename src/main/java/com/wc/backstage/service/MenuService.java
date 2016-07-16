package com.wc.backstage.service;

import com.wc.backstage.bean.Menu;
import com.wc.backstage.dao.MenuDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rubi on 13-12-29.
 */
@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public long add(Menu menu) {
        return menuDao.insert(menu);
    }

    public long update(Menu menu) {
        return menuDao.update(menu);
    }

    public long delete(long id) {
        return menuDao.delete(id);
    }

    public Menu getById(long id) {

        return menuDao.getEntityById(id);
    }

    public List<Menu> list(Menu menu, String order) {
        List<Menu> pc = menuDao.getListByObj(menu, null, null, order);
        return pc;
    }

    public PagerControl<Menu> page(Menu menu, PageInfo pi, String order) {
        PagerControl<Menu> pc = menuDao.getPagerByObj(menu, pi, null, order);
        return pc;
    }
}
