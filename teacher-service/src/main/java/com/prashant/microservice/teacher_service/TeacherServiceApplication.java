package com.prashant.microservice.teacher_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.common.model")
@ComponentScan(basePackages = {
	    "com.prashant.microservice.teacher_service",
	    "com.example.common"
	})

public class TeacherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherServiceApplication.class, args);
	}

}

