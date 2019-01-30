package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger("Login");
    public Map<String,String> login(String username, String password){
        Map<String,String> map = new HashMap<String,String>();
        logger.info("login-------------------------------------------------------------");
        logger.info("请求参数：username:" + username + "    password:" + password);
        logger.info("查询数据库...");
        String message = "";
        try{
            User user = userMapper.queryUserByUsername(username);
            if(password.equals(user.getPassword())){
                message = "success";
                map.put("message",message);
                map.put("head",user.getHead());
                map.put("nickname",user.getNickname());
                map.put("sex",user.getSex());
                map.put("email",user.getEmail());
                map.put("mobile",user.getMobile());
                map.put("birthday",user.getBirthday());
                map.put("introduce",user.getIntroduce());
            }
            else{
                message = "password error";
                map.put("message",message);
            }
            logger.info(message);
            return map;
        }
        catch (NullPointerException e){
            message = "user not exist";
            logger.info(message);
            map.put("message",message);
            return map;
        }
        catch (Exception e){
            logger.error(e.toString());
            map.put("message",e.toString());
            return map;
        }
    }
}
