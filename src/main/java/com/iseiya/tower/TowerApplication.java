package com.iseiya.tower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TowerApplication.class, args);
    }

}
