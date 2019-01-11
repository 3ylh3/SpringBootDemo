package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SpringBootDemo")
public class QueryController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/query")
    public String query(){
        return messageService.getMessage("1").getMessage();
    }
}
