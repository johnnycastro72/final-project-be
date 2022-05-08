package com.sofkau.finalprojectbe;

import com.sofkau.finalprojectbe.converters.SingleModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * This is the main class.
 * <p>
 *
 * @author Jhonny Castro johnny.castro@misena.edu.co
 * @version 1.0.0 7/05/2022
 * @since 1.0.0
 *
 * @params args <String[]>
 */
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
