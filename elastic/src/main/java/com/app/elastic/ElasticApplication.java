package com.app.elastic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ElasticApplication{

    public static void main(String[] args) {
        new SpringApplicationBuilder(ElasticApplication.class).run(args);
    }

}
