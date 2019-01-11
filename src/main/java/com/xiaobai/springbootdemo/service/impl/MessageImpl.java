package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.dao.MessageMapper;
import com.xiaobai.springbootdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public Message getMessage(String id){
        Message message = messageMapper.getMessage(id);
        return message;
    }
}
