package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Head;
import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.service.SaveHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class SaveHeadController {
    @Autowired
    SaveHeadService saveHeadService;
    @RequestMapping("/saveHead")
    public Message saveHead(@RequestBody Head head, HttpSession session){
        Message message = new Message();
        String tmpImg = head.getHead();
        String username = session.getAttribute("username").toString();
        message.setMessage(saveHeadService.saveHead(username,tmpImg,session));
        return message;
    }
}
