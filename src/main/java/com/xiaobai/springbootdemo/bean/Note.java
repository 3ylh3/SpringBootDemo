package com.xiaobai.springbootdemo.bean;

public class Note {
    private String title;
    private String note;
    private String date;
    private int num;

    public int getNum() {
        return num;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
