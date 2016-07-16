package com.wc.user.bean;

import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

import static org.apache.commons.lang.time.DateUtils.truncatedCompareTo;

public class Repair {
    //0 未受理 1 处理中 2 处理完成
    public static final short WAITTING = 0;
    public static final short DEALING = 1;
    public static final short FINISH = 2;

    public static final short GRADE_BAD = 0;
    public static final short GRADE_GOOD = 1;
    public static final short GRADE_VERYGOOD = 2;
    private Long id;

    private String title;

    private String content;

    private String img;

    private Date createTime;

    private Long userId;

    private Short status;

    private String mobile;

    private Long communityId;

    private Short grade;

    private Long followId;

    private String followName;

    private Date followTime;

    private Date finishTime;

    private String address;

    private String communityName;

    private String nickname;

    private Boolean overTime;

    private static Date threeDateAgo = DateUtils.addDays(new Date(), -3);

    public Boolean getOverTime() {
        return overTime;
    }

    public void setOverTime(Boolean overTime) {
        this.overTime = overTime;
    }

    //是否超时
    public boolean haveOverTime() {
        return truncatedCompareTo(createTime, threeDateAgo, Calendar.SECOND) < 0;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}