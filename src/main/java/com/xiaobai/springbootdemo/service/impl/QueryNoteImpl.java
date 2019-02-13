package com.xiaobai.springbootdemo.service.impl;

import com.xiaobai.springbootdemo.bean.Note;
import com.xiaobai.springbootdemo.dao.NoteMapper;
import com.xiaobai.springbootdemo.service.QueryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryNoteImpl implements QueryNoteService {
    @Autowired
    NoteMapper noteMapper;
    public Note queryNoteByTitle(String username,String title){
        return noteMapper.queryNoteByTitle(username,title);
    }
    public Double queryTotalNum(String username){
        return noteMapper.queryTotalNum(username);
    }
    public List<Note> queryNotesByUsername(String username,int start,int end){
        return noteMapper.queryNotesByUsername(username,start,end);
    }
    public void addNum(String username,String title){
        noteMapper.addNum(username,title);
    }
    public List<Note> queryPopularNote(String username){
        return noteMapper.queryPopularNote(username);
    }
}
