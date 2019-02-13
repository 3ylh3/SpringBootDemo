package com.xiaobai.springbootdemo.service;

import com.xiaobai.springbootdemo.bean.Note;

import java.util.List;

public interface QueryNoteService {
    public Note queryNoteByTitle(String username,String title);
    public Double queryTotalNum(String username);
    public List<Note> queryNotesByUsername(String username,int start,int end);
    public void addNum(String username,String title);
    public List<Note> queryPopularNote(String username);
}
