package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.LuckyMoneyLog;
import com.wc.user.dao.LuckyMoneyLogDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class LuckyMoneyLogService {


    @Autowired
    private LuckyMoneyLogDao luckyMoneyLogDao;

    /**
     * @param luckyMoney
     * @return id 主键
     */
    public long add(LuckyMoneyLog luckyMoney) {
        return luckyMoneyLogDao.insert(luckyMoney);
    }

    public long update(LuckyMoneyLog luckyMoney) {
        return luckyMoneyLogDao.update(luckyMoney);
    }

    public long delete(long id) {
        return luckyMoneyLogDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public LuckyMoneyLog getById(long id) {

        return luckyMoneyLogDao.getEntityById(id);
    }

    /**
     * 根据id获取
     *
     * @param log
     * @return
     */
    public LuckyMoneyLog get(LuckyMoneyLog log) {
        return luckyMoneyLogDao.getEntityByObj(log);
    }

    public List<LuckyMoneyLog> list(LuckyMoneyLog luckyMoney, String order) {
        List<LuckyMoneyLog> pc = luckyMoneyLogDao.getListByObj(luckyMoney, null, null, order);
        return pc;
    }

    public int count(LuckyMoneyLog luckyMoney) {
        return luckyMoneyLogDao.getCountByObj(luckyMoney);
    }

    public PagerControl<LuckyMoneyLog> page(LuckyMoneyLog luckyMoney, PageInfo pi, String order) {
        PagerControl<LuckyMoneyLog> pc = luckyMoneyLogDao.getPagerByObj(luckyMoney, pi, null, order);
        return pc;
    }

    public PagerControl<LuckyMoneyLog> pageWithMember(LuckyMoneyLog query, PageInfo pi) {
        if (null != query && StringUtils.isNotBlank(query.getUserName())) {
            String like = "%" + query.getUserName() + "%";
            query.setUserName(like);
        }
        PagerControl<LuckyMoneyLog> pc = luckyMoneyLogDao.pageWithMember(query, pi, null, "order by l.id desc");
        return pc;
    }

}
