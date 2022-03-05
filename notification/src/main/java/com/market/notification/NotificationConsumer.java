package com.market.notification;

import com.market.notification.service.NotificationService;
import com.market.notification.service.RestNotificationCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(RestNotificationCommand command) {
        log.info("Consumed {} from queue", command);
        notificationService.createNotification(command);
        log.info("Consumed {} from queue", command);
    }
}
