package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.SaveUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class SaveUserInfoController {
    @Autowired
    SaveUserInfoService saveUserInfoService;
    @RequestMapping("/saveUserInfo")
    public Message save(@RequestBody User user, HttpSession session){
        Message message = new Message();
        message.setMessage(saveUserInfoService.saveUserInfo(user.getUsername(),user.getNickname(),user.getSex(),user.getEmail(),user.getMobile(),user.getBirthday(),user.getIntroduce(),session));
        return message;
    }
}
