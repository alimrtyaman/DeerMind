package com.aliyaman.deermind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.aliyaman.deermind"})
@EntityScan(basePackages = {"com.aliyaman.deermind"})
@SpringBootApplication
public class DeerMindApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeerMindApplication.class, args);
    }

}
