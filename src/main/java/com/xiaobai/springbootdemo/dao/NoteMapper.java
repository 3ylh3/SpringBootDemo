package com.xiaobai.springbootdemo.dao;

import com.xiaobai.springbootdemo.bean.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteMapper {
    public void addNote(@Param("username")String username,@Param("title")String title,@Param("note")String note,@Param("date")String date);
    public Note queryNoteByTitle(@Param("username")String username,@Param("title")String title);
    public Double queryTotalNum(@Param("username")String username);
    public List<Note> queryNotesByUsername(@Param("username")String username,@Param("start")int start,@Param("end")int end);
    public void addNum(@Param("username")String name,@Param("title")String title);
    public List<Note> queryPopularNote(@Param("username")String username);
}
