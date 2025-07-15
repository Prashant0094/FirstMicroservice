package com.prashant.microservice.teacher_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
     BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

