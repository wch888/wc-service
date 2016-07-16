package com.wc.user.dao.impl;

import com.wc.common.db.BaseDao;
import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Member;
import com.wc.user.bean.MemberDTO;
import com.wc.user.dao.MemberDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2014-08-29.
 */
@Repository
public class MemberDaoImpl extends BaseDao<Long, Member> implements MemberDao {

    @Override
    public PagerControl<MemberDTO> pageWithDetail(Member entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountWithMember(entity, whereSql);
        if (total1 > 0) {
            list = this.getListWithDetail(entity, pageInfo, whereSql, orderBySql);
        }
        if (null != pageInfo) {
            pageInfo.setTotalCounts(total1);
        }
        if (list != null) {
            pagerControl.setEntityList((List) list);
        }

        pagerControl.setPageInfo(pageInfo);
        return pagerControl;
    }

    @Override
    public List<MemberDTO> getListWithDetail(Member entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfoDTO", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }

    public int getCountWithMember(Member entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntityMemberDTO", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }
}
