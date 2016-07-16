package com.wc.user.bean;

import java.util.Date;

public class Message {

    public static final short UNREAD = 0;
    public static final short READ = 1;
    private Long id;

    private Long receiveId;
    private String receiverName;
    private String receiverHead;
    private String content;
    private Long pid;

    private Short status;

    private Date createTime;
    private Long senderId;
    private String senderName;
    private String senderHead;

    private Long all;

    public Long getAll() {
        return all;
    }

    public void setAll(Long all) {
        this.all = all;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverHead() {
        return receiverHead;
    }

    public void setReceiverHead(String receiverHead) {
        this.receiverHead = receiverHead;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderHead() {
        return senderHead;
    }

    public void setSenderHead(String senderHead) {
        this.senderHead = senderHead;
    }
}