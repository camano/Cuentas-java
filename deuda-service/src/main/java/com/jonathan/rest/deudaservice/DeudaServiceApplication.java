package com.jonathan.rest.deudaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeudaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeudaServiceApplication.class, args);
    }

}
