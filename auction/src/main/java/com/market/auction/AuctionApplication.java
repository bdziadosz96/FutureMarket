package com.market.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.market.auction",
                "com.market.rabbit",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.market.clients.item", "com.market.clients.notification"}
)
public class AuctionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuctionApplication.class, args);
    }
}
