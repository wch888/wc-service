package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Wallet;

public interface WalletDao extends IDao<Long, Wallet> {


    PagerControl<Wallet> pageWithMember(Wallet wallet, PageInfo pageInfo, String whereSql, String orderBySql);
}