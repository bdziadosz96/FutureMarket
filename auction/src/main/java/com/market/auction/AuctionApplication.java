package com.market.auction;

import com.market.rabbit.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.market.auction",
                "com.market.rabbit",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.market.clients.item","com.market.clients.notification"}
)
public class AuctionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuctionApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
                                        AuctionRabbitConfig notificationConfig) {
        return args -> {
            producer.publish(
                    "hello in " + AuctionApplication.class.getName(),
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey());
        };
    }
}
