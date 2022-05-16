package com.example.demods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class DemoDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDsApplication.class, args);
    }

}
