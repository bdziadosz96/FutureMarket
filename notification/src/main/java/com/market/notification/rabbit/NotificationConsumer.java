package com.market.notification.rabbit;

import com.market.notification.service.RestNotificationCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    public void consumer(RestNotificationCommand notificationCommand) {

    }
}
