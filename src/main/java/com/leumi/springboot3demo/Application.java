package com.leumi.springboot3demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }

    /*
     * @Bean
     * CommandLineRunner runner() {
     * return args -> {
     * Run run = new Run(1, "First Run", LocalDateTime.now(),
     * LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
     * log.info("Run12:" + run);
     * };
     * }
     * 
     */
    
}
