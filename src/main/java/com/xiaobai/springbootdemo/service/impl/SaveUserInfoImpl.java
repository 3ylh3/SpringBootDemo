package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.UserMapper;
import com.xiaobai.springbootdemo.service.SaveUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SaveUserInfoImpl implements SaveUserInfoService {
    @Autowired
    UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger("SaveUserInfo");
    public String saveUserInfo(String username, String nickname, String sex, String email, String mobile, String birthday, String introduce, HttpSession session){
        logger.info("saveUserInfo------------------------------------------------------");
        try{
            logger.info("username:" + username);
            logger.info("nickname:" + nickname);
            logger.info("sex:" + sex);
            logger.info("email:" + email);
            logger.info("mobile:" + mobile);
            logger.info("birthday:" + birthday);
            logger.info("introduce:" + introduce);
            logger.info("更新数据库...");
            userMapper.saveUserInfo(username,nickname,sex,email,mobile,birthday,introduce);
            logger.info("更新成功");
            logger.info("更新session...");
            session.setAttribute("nickname",nickname);
            session.setAttribute("sex",sex);
            session.setAttribute("email",email);
            session.setAttribute("mobile",mobile);
            session.setAttribute("birthday",birthday);
            session.setAttribute("introduce",introduce);
            logger.info("更新成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
