package com.smart4d.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.smart4d.restservice.services")
@EntityScan("com.smart4d.restservice.entities")
@EnableJpaRepositories("com.smart4d.restservice.repositories")
public class RestServiceApplication{
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}