package com.xiaobai.springbootdemo.controller;

import com.xiaobai.springbootdemo.bean.Note;
import com.xiaobai.springbootdemo.service.QueryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/SpringBootDemo")
public class PageTransitionController {
    @Autowired
    private QueryNoteService queryNoteService;
    @RequestMapping("")
    public String index(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/home")
    public String home(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        HttpSession session = request.getSession();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            String username = session.getAttribute("username").toString();
            model.addAttribute("username",username);
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            //查询笔记总条数
            double noteNums = queryNoteService.queryTotalNum(username);
            List<Integer> nums = new ArrayList<Integer>();
            for(int i = 1;i <= Math.ceil(noteNums / 20);i++){
                nums.add(i);
            }
            model.addAttribute("nums",nums);
            //分页查询笔记
            List<Note> notes = queryNoteService.queryNotesByUsername(username,0,20);
            model.addAttribute("notes",notes);
            model.addAttribute("index",1);
            //查询阅读量前五的笔记
            List<Note> popularNote = queryNoteService.queryPopularNote(username);
            model.addAttribute("popularNote",popularNote);
            return "home";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/registerSuccess")
    public String regesterSuccess(){
        return "registerSuccess";
    }
    @RequestMapping("/usercenter")
    public String usercenter(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        HttpSession session = request.getSession();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            model.addAttribute("username",session.getAttribute("username"));
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            model.addAttribute("sex",session.getAttribute("sex"));
            model.addAttribute("email",session.getAttribute("email"));
            model.addAttribute("mobile",session.getAttribute("mobile"));
            model.addAttribute("birthday",session.getAttribute("birthday"));
            model.addAttribute("introduce",session.getAttribute("introduce"));
            return "userCenter";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
    @RequestMapping("/newNote")
    public String newNote(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        HttpSession session = request.getSession();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            model.addAttribute("username",session.getAttribute("username"));
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            return "newNote";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
    @RequestMapping("/queryNoteByPage")
    public String queryNoteByPage(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        String tempPage = request.getParameter("page");
        int page = Integer.valueOf(tempPage);
        int start = (page - 1) * 20;
        HttpSession session = request.getSession();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            String username = session.getAttribute("username").toString();
            model.addAttribute("username",username);
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            //查询笔记总条数
            double noteNums = queryNoteService.queryTotalNum(username);
            List<Integer> nums = new ArrayList<Integer>();
            for(int i = 1;i <= Math.ceil(noteNums / 20);i++){
                nums.add(i);
            }
            model.addAttribute("nums",nums);
            //分页查询笔记
            List<Note> notes = queryNoteService.queryNotesByUsername(username,start,20);
            model.addAttribute("notes",notes);
            model.addAttribute("index",page);
            //查询阅读量前五的笔记
            List<Note> popularNote = queryNoteService.queryPopularNote(username);
            model.addAttribute("popularNote",popularNote);
            return "home";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
    @RequestMapping("/note")
    public String readNote(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        String title = request.getParameter("title");
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            model.addAttribute("username",username);
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            model.addAttribute("title",title);
            //查询笔记内容
            Note note = queryNoteService.queryNoteByTitle(username,title);
            model.addAttribute("note",note);
            //增加阅读次数
            queryNoteService.addNum(username,title);
            return "note";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
    @RequestMapping("/modifyNote")
    public String modifyNote(HttpServletRequest request, Model model){
        String ID = request.getParameter("ID");
        String title = request.getParameter("title");
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        if(ID == null){
            return "redirect:/SpringBootDemo/login";
        }
        else if(ID.equals(session.getId())) {
            model.addAttribute("username",username);
            model.addAttribute("head",session.getAttribute("head"));
            model.addAttribute("nickname",session.getAttribute("nickname"));
            model.addAttribute("title",title);
            //查询笔记内容
            Note note = queryNoteService.queryNoteByTitle(username,title);
            model.addAttribute("note",note.getNote());
            return "modifyNote";
        }
        else{
            return "redirect:/SpringBootDemo/login";
        }
    }
}
