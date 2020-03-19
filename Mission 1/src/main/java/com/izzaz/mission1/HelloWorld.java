package com.izzaz.mission1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorld
{
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

}

/*
* Side note: @Controller for Spring MVC
* @RestController limited to REST web services
* @RequestMapping is for GET methods
*
* */