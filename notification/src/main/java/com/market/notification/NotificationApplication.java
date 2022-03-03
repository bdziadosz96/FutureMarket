package com.market.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.market.notification",
        "com.market.rabbit"
})
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.market.clients.notification"
)
class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//                                        NotificationConfig notificationConfig) {
//        return args -> {
//            producer.publish(
//                    new Person("Bartek", 26),
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }

    record Person(String name, int age) {}
}
