package com.wc.user.dao;


import com.wc.common.db.IDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Member;
import com.wc.user.bean.MemberDTO;

import java.util.List;

public interface MemberDao extends IDao<Long, Member> {


    PagerControl<MemberDTO> pageWithDetail(Member entity, PageInfo pageInfo, String whereSql, String orderBySql);

    List<MemberDTO> getListWithDetail(Member entity, PageInfo pageInfo, String whereSql, String orderBySql);
}