package com.darling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.darling.Dao")
@SpringBootApplication
public class SbglxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbglxtApplication.class, args);
    }

}
