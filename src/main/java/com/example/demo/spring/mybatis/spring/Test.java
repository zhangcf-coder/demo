package com.example.demo.spring.mybatis.spring;

import com.example.demo.spring.mybatis.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		UserService userService = (UserService) context.getBean("userService");
		userService.test();


	}
}
