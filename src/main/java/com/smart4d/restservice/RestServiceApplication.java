package com.smart4d.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import javax.sql.DataSource;

@SpringBootApplication
public class RestServiceApplication implements CommandLineRunner{

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Our DataSource is = " + dataSource);
    }
}