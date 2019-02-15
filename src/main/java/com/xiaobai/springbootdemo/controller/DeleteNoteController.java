package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Message;
import com.xiaobai.springbootdemo.bean.Note;
import com.xiaobai.springbootdemo.service.DeleteNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/SpringBootDemo")
public class DeleteNoteController {
    @Autowired
    private DeleteNoteService deleteNoteService;
    @RequestMapping("/deleteNote")
    public Message deleteNote(HttpSession session, @RequestBody Note note){
        String title = note.getTitle();
        String username = session.getAttribute("username").toString();
        Message message = new Message();
        message.setMessage(deleteNoteService.deleteNote(username,title));
        return message;
    }
}
