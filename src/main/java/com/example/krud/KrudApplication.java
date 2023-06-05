package com.example.krud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrudApplication.class, args);
    }

}
