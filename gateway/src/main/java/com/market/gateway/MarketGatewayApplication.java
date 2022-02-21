package com.market.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
class MarketGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketGatewayApplication.class, args);
    }
}
