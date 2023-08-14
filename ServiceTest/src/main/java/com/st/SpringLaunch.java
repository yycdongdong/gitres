package com.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringLaunch {
    public static void main(String[] args) {
        SpringApplication.run(SpringLaunch.class,args);
    }
}
