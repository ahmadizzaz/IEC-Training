package com.izzaz.mission6_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@EnableAutoConfiguration
public class HelloController {

    @Value("${message:default}")
    private String message;

    @Value("${spring.profiles.active.message}")
    private String message1;

    @GetMapping("/hello")
    public String sayHello(){
        return this.message+ " " + this.message1;
    }

}
