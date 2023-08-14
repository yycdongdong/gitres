package com.csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableFeignClients
public class SpringLaunch {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringLaunch.class, args);

    }
}
