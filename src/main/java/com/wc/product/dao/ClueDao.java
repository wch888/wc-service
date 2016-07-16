package com.wc.product.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.product.bean.Clue;

public interface ClueDao extends IDao<Long, Clue> {


    PagerControl<Clue> pageWithMember(Clue entity, PageInfo pageInfo, String whereSql, String orderBySql);
}