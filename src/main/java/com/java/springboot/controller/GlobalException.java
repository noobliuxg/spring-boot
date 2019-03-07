package com.java.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value=java.lang.Exception.class)
    public ModelAndView handler(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value=java.lang.IllegalArgumentException.class)
    public ModelAndView argumenthandler(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value=java.lang.ArrayIndexOutOfBoundsException.class)
    public ModelAndView outBoundsHandler(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value=java.lang.NullPointerException.class)
    public ModelAndView nullHandler(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value=java.lang.ClassCastException.class)
    public ModelAndView classCastHandler(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value= java.io.IOException.class)
    public ModelAndView ioHandler(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }



}
