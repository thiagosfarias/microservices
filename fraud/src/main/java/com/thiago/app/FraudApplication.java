package com.thiago.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource("classpath:clients-default.properties")
public class FraudApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FraudApplication.class, args);
    }
}
