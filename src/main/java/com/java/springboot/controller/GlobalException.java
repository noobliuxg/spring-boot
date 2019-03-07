package com.java.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * 获取异常的三种方式：
 *      1、@ControllerAdvice+@ExceptionHandler
 *      2、@ExceptionHandler
 *      3、实现HandlerExceptionResolver
 *      4、往spring容器中注入：SimpleMappingExceptionResolver
 */
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


//    @Configuration
//    class CustomerException implements HandlerExceptionResolver {
//
//        @Override
//        public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                                             Object o, Exception e) {
//            ModelAndView mv = new ModelAndView();
//            mv.addObject("msg",e.getMessage());
//            mv.setViewName("error");
//            return null;
//        }
//
//        @Bean
//        public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
//            SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//
//            simpleMappingExceptionResolver.setExcludedExceptions(new Class[]{java.lang.InstantiationException.class});
//
//            simpleMappingExceptionResolver.setDefaultErrorView("error");
//
//            return simpleMappingExceptionResolver;
//        }
//    }

}
