package com.research.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.research")
@EnableEurekaClient

public class Entry {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }

}
