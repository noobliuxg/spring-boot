package com.java.springboot.springboot;

import com.java.springboot.filter.HelloFilter;
import com.java.springboot.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.Filter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean<HelloServlet> servletServletRegistrationBean = new ServletRegistrationBean<>();

		servletServletRegistrationBean.addUrlMappings("/hello");
		servletServletRegistrationBean.setServlet(new HelloServlet());

		return servletServletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new HelloFilter());
		filter.addUrlPatterns("/*");
		return filter;
	}
}
