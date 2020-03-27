package com.izzaz.mission6_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.AbstractEnvironment;

@EnableConfigServer
@SpringBootApplication
public class Mission61Application {

    public static void main(String[] args) {
        SpringApplication.run(Mission61Application.class, args);
    }

}
