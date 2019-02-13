package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.Note;
import com.xiaobai.springbootdemo.service.SaveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class SaveNoteController {
    @Autowired
    SaveNoteService saveNoteService;
    @RequestMapping("/saveNote")
    public Message saveNote(@RequestBody Note note, HttpSession session){
        Message message = new Message();
        String username = session.getAttribute("username").toString();
        message.setMessage(saveNoteService.saveNote(username,note.getTitle(), note.getNote()));
        return message;
    }
}
