package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Community;
import com.wc.user.dao.CommunityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class CommunityService {

    @Autowired
    private CommunityDao communityDao;

    /**
     * 增加用户
     *
     * @param community
     * @return id 主键
     */
    public long add(Community community) {
        return communityDao.insert(community);
    }

    public long update(Community community) {
        return communityDao.update(community);
    }

    public long delete(long id) {
        return communityDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Community getById(long id) {

        return communityDao.getEntityById(id);
    }

    public List<Community> list(Community community, String order) {
        List<Community> pc = communityDao.getListByObj(community, null, null, order);
        return pc;
    }

    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Community> page(Community community, PageInfo pi, String order) {
        PagerControl<Community> pc = communityDao.getPagerByObj(community, pi, null, order);
        return pc;
    }
}
