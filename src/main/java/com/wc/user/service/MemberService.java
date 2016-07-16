package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Member;
import com.wc.user.bean.MemberDTO;
import com.wc.user.bean.MemberDetail;
import com.wc.user.bean.Wallet;
import com.wc.user.dao.MemberDao;
import com.wc.user.dao.MemberDetailDao;
import com.wc.user.dao.WalletDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberDetailDao memberDetailDao;

    @Autowired
    private WalletDao walletDao;

    /**
     * 增加用户
     *
     * @param member
     * @return id 主键
     */
    public long add(Member member) {
        memberDao.insert(member);
        Wallet wallet = new Wallet();
        wallet.setId(member.getId());
        walletDao.insert(wallet);
        MemberDetail detail = new MemberDetail();
        detail.setId(member.getId());
        memberDetailDao.insert(detail);
        return member.getId();
    }

    public long update(Member member) {
        memberDao.update(member);
        return member.getId();
    }

    public int delete(long id) {
        return memberDao.delete(id);
    }

    public int updateDetail(MemberDetail detail) {
        return memberDetailDao.update(detail);
    }

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Member getById(long id) {

        return memberDao.getEntityById(id);
    }

    public MemberDetail getDetailById(long id) {

        return memberDetailDao.getEntityById(id);
    }



    /**
     * 根据用户名查找
     */
    public Member getByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return null;
        }
        Member member = new Member();
        member.setMobile(userName);
        return memberDao.getEntityByObj(member);

    }

    public Member get(Member member) {
        List<Member> list = memberDao.getListByObj(member);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<MemberDetail> list(MemberDetail detail) {
        return memberDetailDao.getListByObj(detail, "", "order by id asc");
    }

    public PagerControl<Member> page(Member memeber, PageInfo pi, String order) {
        if (null != memeber && StringUtils.isNotBlank(memeber.getNickname())) {
            String like = "%" + memeber.getNickname() + "%";
            memeber.setNickname(like);
        }
        if (null != memeber && StringUtils.isNotBlank(memeber.getMobileLike())) {
            String like = "%" + memeber.getMobileLike() + "%";
            memeber.setMobileLike(like);
        }
        PagerControl<Member> pc = memberDao.getPagerByObj(memeber, pi, null, order);
        return pc;
    }

    public PagerControl<MemberDTO> pageWithDetail(Member memeber, PageInfo pi, String order) {
        if (null != memeber && StringUtils.isNotBlank(memeber.getNickname())) {
            String like = "%" + memeber.getNickname() + "%";
            memeber.setNickname(like);
        }
        if (null != memeber && StringUtils.isNotBlank(memeber.getMobileLike())) {
            String like = "%" + memeber.getMobileLike() + "%";
            memeber.setMobileLike(like);
        }
        PagerControl<MemberDTO> pc = memberDao.pageWithDetail(memeber, pi, null, order);
        return pc;
    }

    public List<MemberDTO> listWithDetail(Member memeber) {
        if (null != memeber && StringUtils.isNotBlank(memeber.getNickname())) {
            String like = "%" + memeber.getNickname() + "%";
            memeber.setNickname(like);
        }
        if (null != memeber && StringUtils.isNotBlank(memeber.getMobileLike())) {
            String like = "%" + memeber.getMobileLike() + "%";
            memeber.setMobileLike(like);
        }
        List<MemberDTO> pc = memberDao.getListWithDetail(memeber, null, null, "order by m.id desc");
        return pc;
    }

    public Integer count(Member memeber) {
        return memberDao.getCountByObj(memeber);
    }
}
