package com.java.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @RequestMapping("/show")
    public String show(Model model, HttpServletRequest request){
        model.addAttribute("msg", "Thymeleaf 第一个案例");
        model.addAttribute("sex","1");
        model.addAttribute("id","2");
        List<User> list = new ArrayList<>();
        for (int i=0;;){
            if (i>=10) break;
            i++;
            list.add(new User("AP52"+i,"liuxg+"+i,5+i));
        }
        model.addAttribute("list",list);
        Map<String,User> map = new HashMap<>();
        map.put("ID1",new User("ID1","张三",12));
        map.put("ID2",new User("ID2","李四",13));
        map.put("ID3",new User("ID3","王五",14));
        model.addAttribute("map",map);
        request.setAttribute("requestScope","AAA");
        request.getSession().setAttribute("sessionScope","BBB");
        request.getServletContext().setAttribute("applicationScope","CCC");
        return "index";
    }

    @RequestMapping("/path/{id}/{name}/show")
    public String path(@PathVariable String id,@PathVariable String name){
        System.out.println("id:"+id+" name:"+name);
        return "index";
    }
}
