package com.wc.user.service;

import com.wc.common.db.PageInfo;
import com.wc.common.db.PagerControl;
import com.wc.user.bean.Message;
import com.wc.user.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 14-12-29.
 */
@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;


    public long add(Message message) {
        return messageDao.insert(message);
    }

    public long update(Message message) {
        messageDao.update(message);
        return message.getId();
    }

    public long delete(long id) {
        return messageDao.delete(id);
    }


    public Message getById(long id) {

        return messageDao.getEntityById(id);
    }


    public Message get(Message message) {
        List<Message> list = messageDao.getListByObj(message);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


    /**
     * @return
     */
    public List<Message> list(Message message, PageInfo pi) {
        List<Message> pc = messageDao.getListByObj(message, pi, null, "order by id desc");
        return pc;
    }

    /**
     * @return
     */
    public PagerControl<Message> page(Message message, PageInfo pi) {
        PagerControl<Message> pc = messageDao.getPagerByObj(message, pi, null, "order by id desc");
        return pc;
    }

    public long getProductBespeak(long pid, long userId) {
        Message query = new Message();
        query.setPid(pid);
        query.setSenderId(userId);
        List<Message> list = messageDao.getListByObj(query, new PageInfo(), null);
        long receiveId = 0;
        if (!list.isEmpty()) {
            //获取之前的置业顾问
            receiveId = list.get(0).getReceiveId();
        }
        return receiveId;
    }
}
