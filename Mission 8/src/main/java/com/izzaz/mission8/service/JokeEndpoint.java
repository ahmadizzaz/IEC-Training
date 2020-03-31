package com.izzaz.mission8.service;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Endpoint(id="joke")
@Component
public class JokeEndpoint {

    @ReadOperation
    @Bean
    public String testJoke() {
        return "Why do game developers not wear glasses?\nBecause they can C#";
    }

}
