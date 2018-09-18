package com.andy.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Leone
 * @since 2017-12-5
 */
@EnableSwagger2
@SpringBootApplication
public class SpringSecurityTestApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTestApp.class, args);
    }
}
