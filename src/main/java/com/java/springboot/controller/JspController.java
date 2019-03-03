package com.java.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping
    public String list(Model model){
        List<User> list = new ArrayList<>();
        for (int i=0;;){
            if (i>=10){
                break;
            }
            list.add(new User("AP201"+i,"liuxg"+i,15+i));
        }
        model.addAttribute("list",list);
        return "list";
    }
}
