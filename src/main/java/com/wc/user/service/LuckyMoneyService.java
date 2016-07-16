package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.LuckyMoney;
import com.wc.user.bean.LuckyMoneyLog;
import com.wc.user.bean.LuckyMoneyProduct;
import com.wc.user.dao.LuckyMoneyDao;
import com.wc.user.dao.LuckyMoneyLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class LuckyMoneyService {

    @Autowired
    private LuckyMoneyDao luckyMoneyDao;

    @Autowired
    private LuckyMoneyLogDao luckyMoneyLogDao;

    /**
     * 缓存
     */
    private static Map<Long, LuckyMoney> cache = new HashMap<Long, LuckyMoney>();
    /**
     * 增加用户
     *
     * @param luckyMoney
     * @return id 主键
     */
    public long add(LuckyMoney luckyMoney) {
        return luckyMoneyDao.insert(luckyMoney);
    }

    public long addLog(LuckyMoneyLog luckyMoneyLog) {
        return luckyMoneyLogDao.insert(luckyMoneyLog);
    }

    public long update(LuckyMoney luckyMoney) {
        cache.clear();
        return luckyMoneyDao.update(luckyMoney);
    }

    public long delete(long id) {
        cache.clear();
        return luckyMoneyDao.delete(id);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public LuckyMoney getById(long id) {
        LuckyMoney money = cache.get(id);
        if(null==money){
            money= luckyMoneyDao.getEntityById(id);
            if(null!=money){
                cache.put(id,money);
            }
        }
        return money;
    }

    /**
     * 只获取有效的
     *
     * @param productId
     * @return
     */
    public LuckyMoney getByProductId(long productId) {

        LuckyMoney query = new LuckyMoney();
        query.setPid(productId);
        query.setStatus(LuckyMoney.VALID);
        List<LuckyMoney> list = luckyMoneyDao.getListByObj(query, "end_time > start_time", "order by id desc");
        if (!list.isEmpty()) {
            LuckyMoney luckyMoney = list.get(0);
            return luckyMoney;
        }
        return null;
    }

    public List<LuckyMoney> list(LuckyMoney luckyMoney, String order) {
        List<LuckyMoney> pc = luckyMoneyDao.getListByObj(luckyMoney, null, null, order);
        return pc;
    }

    public PagerControl<LuckyMoney> page(LuckyMoney luckyMoney, PageInfo pi, String order) {
        PagerControl<LuckyMoney> pc = luckyMoneyDao.getPagerByObj(luckyMoney, pi, null, order);
        return pc;
    }

    public PagerControl<LuckyMoneyProduct> page(LuckyMoneyProduct luckyMoney, PageInfo pi, String order) {
        PagerControl<LuckyMoneyProduct> pc = luckyMoneyDao.getPagerWithProduct(luckyMoney, pi, null, order);
        return pc;
    }

    public PagerControl<LuckyMoneyLog> page(LuckyMoneyLog query, PageInfo pi, String order) {
        PagerControl<LuckyMoneyLog> pc = luckyMoneyLogDao.getPagerByObj(query, pi, null, order);
        return pc;
    }



}
