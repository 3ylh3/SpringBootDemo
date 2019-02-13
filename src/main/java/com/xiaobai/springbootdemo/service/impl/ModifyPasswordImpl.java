package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.ModifyPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ModifyPasswordImpl implements ModifyPasswordService {
    @Autowired
    UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger("ModifyPassword");
    public String modifyPassword(String username, String password, HttpSession session){
        logger.info("modifyPassword---------------------------------------------------");
        try {
            logger.info("原密码：" + session.getAttribute("password"));
            logger.info("新密码：" + password);
            logger.info("更新数据库...");
            userMapper.modifyPassword(username,password);
            logger.info("更新成功");
            logger.info("更新session...");
            session.setAttribute("password",password);
            logger.info("更新成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
