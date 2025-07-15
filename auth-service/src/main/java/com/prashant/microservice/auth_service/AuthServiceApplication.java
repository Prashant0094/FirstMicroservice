package com.prashant.microservice.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.common.model")
@EnableJpaRepositories(basePackages = "com.prashant.microservice.auth_service.temporaryrepo")
@ComponentScan(basePackages = {
    "com.prashant.microservice.auth_service", 
    "com.example.common"  
})
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
