package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Image;
import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.service.AddImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/SpringBootDemo")
public class AddImgController {
    @Autowired
    AddImgService addImgService;
    @RequestMapping("/addImg")
    public Message addImg(@RequestBody Image image){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String img = uuid + ".jpg";
        String tmpImg = image.getImg();
        Message message = new Message();
        message.setImg(img);
        message.setMessage(addImgService.addImg(img,tmpImg));
        return message;
    }
}
