package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.ModifyPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class ModifyPasswordController {
    @Autowired
    private ModifyPasswordService modifyPasswordService;
    @RequestMapping("/modifyPassword")
    public Message modifyPassword(@RequestBody User user, HttpSession session){
        Message message = new Message();
        message.setMessage(modifyPasswordService.modifyPassword(user.getUsername(),user.getPassword(),session));
        return message;
    }
}
