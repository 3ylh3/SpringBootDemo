package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.NoteMapper;
import com.xiaobai.springbootdemo.service.SaveNoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SaveNoteImpl implements SaveNoteService {
    @Autowired
    NoteMapper noteMapper;
    private Logger logger;
    public String saveNote(String username,String title,String note){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        logger = LoggerFactory.getLogger("AddNote");
        logger.info("addNote----------------------------------------------------------");
        logger.info("用户:" + username);
        logger.info("标题:" + title);
        logger.info("日期:" + date);
        logger.info("添加数据库...");
        try {
            noteMapper.addNote(username, title, note, date);
            logger.info("添加成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
