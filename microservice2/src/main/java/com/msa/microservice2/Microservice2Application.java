package com.msa.microservice2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class Microservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservice2Application.class, args);
    }

    // to consume from microservice1
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    static
    class ConsumerController {
        @Autowired
        private RestTemplate restTemplate;
        @GetMapping("api/message")
        @HystrixCommand(fallbackMethod = "getDefaultMessage")
        public String getMessageFromMs1(){
           final String message =  restTemplate.getForObject("http://localhost:9091/api/test/message",
                    String.class);
           return message;
        }
        public String getDefaultMessage(){
            return "This is a Default message to display if not available";
        }
    }
}