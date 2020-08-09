package com.example.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CalcSpring {

    @Autowired
    private CalcClient client;


    @GetMapping("/sum")
    public AddResponse getSum() {
        return client.getAddResponse();
    }
    public static void main(String[] args) {
        SpringApplication.run(CalcSpring.class, args);
    }

}
