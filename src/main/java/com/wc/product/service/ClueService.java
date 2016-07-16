package com.wc.product.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Clue;
import com.wc.product.dao.ClueDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class ClueService {

    @Autowired
    private ClueDao clueDao;

    /**
     * 增加用户
     *
     * @param clue
     * @return id 主键
     */
    public long add(Clue clue) {
        return clueDao.insert(clue);
    }

    public int delete(long id) {
        return clueDao.delete(id);
    }

    public long update(Clue clue) {
        clueDao.update(clue);
        return clue.getId();
    }


    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Clue getById(long id) {
        return clueDao.getEntityById(id);
    }


    /**
     * @return
     */
    public PagerControl<Clue> page(Clue clue, PageInfo pi) {
        if (null != clue && StringUtils.isNotBlank(clue.getName())) {
            String like = "%" + clue.getName() + "%";
            clue.setName(like);
        }
        if (null != clue && StringUtils.isNotBlank(clue.getMobile())) {
            String like = "%" + clue.getMobile() + "%";
            clue.setMobile(like);
        }
        PagerControl<Clue> pc = clueDao.getPagerByObj(clue, pi, null,  "order by id desc");
        return pc;
    }
    /**
     * @return
     */
    public PagerControl<Clue> pageMember(Clue clue, PageInfo pi) {
        if (null != clue && StringUtils.isNotBlank(clue.getName())) {
            String like = "%" + clue.getName() + "%";
            clue.setName(like);
        }
        if (null != clue && StringUtils.isNotBlank(clue.getMobile())) {
            String like = "%" + clue.getMobile() + "%";
            clue.setMobile(like);
        }
        PagerControl<Clue> pc = clueDao.pageWithMember(clue, pi, null,  "order by c.id desc");
        return pc;
    }

    /**
     * @return
     */
    public int count(Clue clue) {
        int count = clueDao.getCountByObj(clue);
        return count;
    }

}
