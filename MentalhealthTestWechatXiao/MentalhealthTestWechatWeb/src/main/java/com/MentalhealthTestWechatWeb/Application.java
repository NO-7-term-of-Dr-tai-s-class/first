package com.MentalhealthTestWechatWeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;


@ComponentScan(basePackages = {"com.MentalhealthTestWechatWeb.service"})//用于扫描mybatis的Mapper接口，根据扫描到的接口生成代理对象
@ComponentScan(basePackages = {"com.MentalhealthTestWechatWeb.controller"})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}
	 
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
