package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Repair;
import com.wc.user.bean.RepairComment;
import com.wc.user.dao.RepairCommentDao;
import com.wc.user.dao.RepairDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class RepairService {

    @Autowired
    private RepairDao repairDao;

    @Autowired
    private RepairCommentDao repairCommentDao;


    public long add(Repair repair) {
        return repairDao.insert(repair);
    }

    public long update(Repair repair) {
        return repairDao.update(repair);
    }

    public long delete(long id) {
        return repairDao.delete(id);
    }

    public long addComment(RepairComment comment) {
        return repairCommentDao.insert(comment);
    }

    public List<RepairComment> list(RepairComment comment) {
        return repairCommentDao.getListByObj(comment, "", "order by id desc");
    }

    public Repair getById(long id) {

        return repairDao.getEntityById(id);
    }

    public PagerControl<Repair> page(Repair repair, PageInfo pi) {
        PagerControl<Repair> pc = repairDao.getPagerByObj(repair, pi, null,  "order by id desc");
        return pc;
    }

    public PagerControl<Repair> pageWithMember(Repair repair, PageInfo pi) {
        if (null != repair && StringUtils.isNotBlank(repair.getMobile())) {
            String like = "%" + repair.getMobile() + "%";
            repair.setMobile(like);
        }
        if (null != repair && StringUtils.isNotBlank(repair.getAddress())) {
            String like = "%" + repair.getAddress() + "%";
            repair.setAddress(like);
        }
        PagerControl<Repair> pc = repairDao.pageWithMember(repair, pi, null, "order by r.id desc");
        return pc;
    }

    public int count(Repair repair) {
        return repairDao.getCountByObj(repair);
    }
}
