package com.brij.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "com.brij.examples")
@SpringBootApplication
public class SpringRestExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestExampleApplication.class, args);
    }

}
