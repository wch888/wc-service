package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Suggest;
import com.wc.user.bean.SuggestComment;
import com.wc.user.dao.SuggestCommentDao;
import com.wc.user.dao.SuggestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class SuggestService {

    @Autowired
    private SuggestDao suggestDao;
    @Autowired
    private SuggestCommentDao suggestCommentDao;

    /**
     * 增加用户
     *
     * @param suggest
     * @return id 主键
     */
    public long add(Suggest suggest) {
        return suggestDao.insert(suggest);
    }

    public long update(Suggest suggest) {
        return suggestDao.update(suggest);
    }

    public long delete(long id) {
        return suggestDao.delete(id);
    }

    public long addComment(SuggestComment comment) {
        return suggestCommentDao.insert(comment);
    }

    public List<SuggestComment> list(SuggestComment comment) {
        return suggestCommentDao.getListByObj(comment, "", "order by id desc");
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Suggest getById(long id) {

        return suggestDao.getEntityById(id);
    }

    /**
     * 推荐用户
     *
     * @return
     */
    public PagerControl<Suggest> page(Suggest suggest, PageInfo pi, String order) {
        PagerControl<Suggest> pc = suggestDao.getPagerByObj(suggest, pi, null, order);
        return pc;
    }
}
