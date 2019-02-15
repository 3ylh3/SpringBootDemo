package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.Note;
import com.xiaobai.springbootdemo.service.ModifyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class ModifyNoteController {
    @Autowired
    ModifyNoteService modifyNoteService;
    @RequestMapping(value = "/modifyNote",method = RequestMethod.POST)
    public Message modifyNote(@RequestBody Note note, HttpSession session){
        String username = session.getAttribute("username").toString();
        String title = note.getTitle();
        String oldTitle = note.getOldTitle();
        String tmpNote = note.getNote();
        Message message = new Message();
        message.setMessage(modifyNoteService.modifyNote(username,title,oldTitle,tmpNote));
        return message;
    }
}
