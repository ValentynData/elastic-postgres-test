package com.app.validate;

import com.app.validate.config.ValidateDistanceConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ValidateDistance {
    public static void main(String[] args){
        new SpringApplicationBuilder(ValidateDistanceConfig.class).run(args);
    }
}
