package com.sofkau.finalprojectbe;

import com.sofkau.finalprojectbe.converters.SingleModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalProjectBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectBeApplication.class, args);
    }

    @Bean
    public SingleModelMapper singleModelMapper() {
        return new SingleModelMapper();
    }
}
