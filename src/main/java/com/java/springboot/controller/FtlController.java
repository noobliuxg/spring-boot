package com.java.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ftl")
public class FtlController {

    @RequestMapping("/showUser")
    public String list(Model model){
        List<User> list = new ArrayList<>();
        for (int i=0;;){
            if (i>=10){
                break;
            }
            i++;
            list.add(new User("AP250"+i,"liu0"+i,18+i));
        }
        model.addAttribute("list",list);
        return "views/user";
    }

}
