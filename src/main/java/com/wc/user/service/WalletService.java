package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Wallet;
import com.wc.user.dao.WalletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class WalletService {

    @Autowired
    private WalletDao walletDao;

    /**
     * 增加积分
     *
     * @return id 主键
     */
    public int addIntegration(long id, long integration) {
        Wallet wallet = walletDao.getEntityById(id);
        Wallet update = new Wallet();
        update.setId(id);
        long own = wallet.getIntegration();
        update.setIntegration(own + integration);
        return walletDao.update(update);
    }

    /**
     * 增加红包
     *
     * @return id 主键
     */
    public int addIntegration(long id, BigDecimal money) {
        Wallet wallet = walletDao.getEntityById(id);
        Wallet update = new Wallet();
        update.setId(id);
        BigDecimal own = wallet.getMoney();
        BigDecimal add = own.add(money);
        update.setMoney(add);
        return walletDao.update(update);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Wallet getById(long id) {

        return walletDao.getEntityById(id);
    }

    public PagerControl<Wallet> page(Wallet memeber, PageInfo pi, String order) {
        PagerControl<Wallet> pc = walletDao.getPagerByObj(memeber, pi, null, order);
        return pc;
    }

    public PagerControl<Wallet> pageWithMember(Wallet wallet, PageInfo pi) {
        PagerControl<Wallet> pc = walletDao.pageWithMember(wallet,pi,"","order by w.id desc");
        return pc;
    }
}
