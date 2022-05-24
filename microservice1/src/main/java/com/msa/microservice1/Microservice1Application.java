package com.msa.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Microservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }

    @RestController
    class MsTestController{
        // comment
        @GetMapping("api/test/message")
        public String displayMessage(){
            return "This is message from MS1";
        }

    }
}
