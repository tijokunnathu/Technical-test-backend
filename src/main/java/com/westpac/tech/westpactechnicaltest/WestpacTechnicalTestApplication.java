package com.westpac.tech.westpactechnicaltest;

import com.westpac.tech.westpactechnicaltest.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@EnableConfigurationProperties(value = {AppProperties.class})

@SpringBootApplication
@EnableCaching
public class WestpacTechnicalTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WestpacTechnicalTestApplication.class, args);
    }

}
