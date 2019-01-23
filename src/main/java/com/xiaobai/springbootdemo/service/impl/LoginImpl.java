package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger("Login");
    public String login(String username,String password){
        logger.info("login-------------------------------------------------------------");
        logger.info("请求参数：username:" + username + "    password:" + password);
        logger.info("查询数据库...");
        String message = "";
        try{
            User user = userMapper.queryUserByUsername(username);
            if(password.equals(user.getPassword())){
                message = "success";
            }
            else{
                message = "password error";
            }
            logger.info(message);
            return message;
        }
        catch (NullPointerException e){
            message = "user not exist";
            logger.info(message);
            return message;
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
