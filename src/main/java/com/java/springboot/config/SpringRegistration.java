package com.java.springboot.config;

import com.java.springboot.filter.HelloFilter;
import com.java.springboot.listener.HelloListener;
import com.java.springboot.servlet.HelloServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;

@Configuration
public class SpringRegistration {

    @Bean
    public ServletRegistrationBean<Servlet> getServletRegistrationBean(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new HelloServlet());
        servletServletRegistrationBean.addUrlMappings("/hello");
        return servletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> getFilterRegistrationBean(){
        FilterRegistrationBean<Filter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new HelloFilter());
        filterBean.addUrlPatterns("/*");
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<ServletContextListener> listenerBean = new ServletListenerRegistrationBean<>();
        listenerBean.setListener(new HelloListener());
        return listenerBean;
    }
}
