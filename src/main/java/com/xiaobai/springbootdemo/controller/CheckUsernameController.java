package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.User;
import com.xiaobai.springbootdemo.service.CheckUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SpringBootDemo")
public class CheckUsernameController {
    @Autowired
    CheckUsernameService checkUsernameService;
    @RequestMapping("/checkUsername")
    public Message checkUsername(@RequestBody User user){
        Message message = new Message();
        message.setMessage(checkUsernameService.checkUsername(user.getUsername()));
        return message;
    }
}
