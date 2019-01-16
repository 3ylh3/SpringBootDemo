package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.CheckUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckUsernameImpl implements CheckUsernameService {
    @Autowired
    UserMapper userMapper;
    public String checkUsername(String username){
        try{
            return userMapper.checkUsername(username);
        }
        catch (Exception e){
            return e.toString();
        }
    }
}
