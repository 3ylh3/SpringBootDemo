package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.dao.NoteMapper;
import com.xiaobai.springbootdemo.service.ModifyNoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyNoteImpl implements ModifyNoteService {
    @Autowired
    private NoteMapper noteMapper;
    private Logger logger = LoggerFactory.getLogger("ModifyNote");
    public String modifyNote(String username,String title,String oldTitle,String note){
        logger.info("modifyNote--------------------------------------------------------");
        logger.info("用户:" + username);
        logger.info("标题:" + oldTitle);
        logger.info("修改后的标题:" + title);
        logger.info("修改后的内容:" + note);
        logger.info("更新数据库...");
        try{
            noteMapper.modifyNote(username, title, oldTitle, note);
            logger.info("修改成功");
            return "success";
        }
        catch (Exception e){
            logger.error(e.toString());
            return e.toString();
        }
    }
}
