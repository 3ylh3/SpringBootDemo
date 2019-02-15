package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.NoteMapper;
import com.xiaobai.springbootdemo.service.DeleteNoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteNoteImpl implements DeleteNoteService {
    @Autowired
    private NoteMapper noteMapper;
    private Logger logger = LoggerFactory.getLogger("DeleteNote");
    public String deleteNote(String username,String title){
        logger.info("delete-------------------------------------------------------------");
        logger.info("用户:" + username);
        logger.info("标题:" + title);
        logger.info("删除...");
        try {
            noteMapper.deleteNote(username,title);
            logger.info("删除成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
