package com.java.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Spring-boot init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
