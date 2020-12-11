package com.example.dynamicdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class DynamicDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (int i = 0; i < beanNames.length; i++) {
                log.info("spring容器中的类第"+(i+1)+"个："+beanNames[i]);
            }
        };
    }
}
