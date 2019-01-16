package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterImpl implements RegisterService {
    @Autowired
    UserMapper userMapper;
    public String register(String username,String password){
        try {
            userMapper.register(username, password);
            return "success";
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
