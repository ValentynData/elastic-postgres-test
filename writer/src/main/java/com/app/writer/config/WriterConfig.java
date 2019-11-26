package com.app.writer.config;

import com.app.elastic.configuration.ElasticConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Random;
import java.util.concurrent.Executor;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.app.writer")
@Import(ElasticConfig.class)
@EnableAsync
public class WriterConfig {

    @Bean
    public Executor executor(){
        int poolSize = Runtime.getRuntime().availableProcessors() * 2;
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(poolSize);
        return executor;
    }

    @Bean
    public Random random(){
        return new Random();
    }

}
