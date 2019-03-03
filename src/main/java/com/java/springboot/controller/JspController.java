package com.java.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping("/list")
    public String list(Model model){
        List<User> list = new ArrayList<>();
        for (int i=0;;){
            if (i>=10){
                break;
            }
            i++;
            list.add(new User("AP201"+i,"liuxg"+i,15+i));
        }
        model.addAttribute("users",list);
        return "/list";
    }

    @RequestMapping(value = "/json",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        for (int i=0;;){
            if (i>=10){
                break;
            }
            i++;
            list.add(new User("AP211"+i,"liuxg_"+i,15+i));
        }
        return list;
    }
}
