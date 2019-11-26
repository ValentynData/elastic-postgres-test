package com.app.postgres.configuration;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.app.postgres.repository")
@EntityScan("com.app.postgres.entity")
public class PostgresConfig {

}
