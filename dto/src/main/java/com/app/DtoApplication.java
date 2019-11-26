package com.app;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DtoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DtoApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
