package com.wc.user.bean;

import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

import static org.apache.commons.lang.time.DateUtils.truncatedCompareTo;

public class Suggest {

    public static final short GRADE_BAD = 0;
    public static final short GRADE_GOOD = 1;
    public static final short GRADE_VERYGOOD = 2;

    private Long id;

    private String title;

    private String content;

    private String img;

    private Long userId;

    private Date createTime;

    private Short grade;

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

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}