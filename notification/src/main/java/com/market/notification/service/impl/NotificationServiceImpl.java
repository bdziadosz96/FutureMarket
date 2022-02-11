package com.market.notification.service.impl;

import com.market.notification.domain.Notification;
import com.market.notification.repository.NotificationRepository;
import com.market.notification.service.NotificationService;
import com.market.notification.service.RestNotificationCommand;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;

    @Override
    public void createNotification(RestNotificationCommand command) {
        repository.save(toNotification(command));
    }

    private Notification toNotification(RestNotificationCommand command) {
        return Notification.builder()
                .auctionId(command.auctionId())
                .itemId(command.itemId())
                .message(command.message())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
