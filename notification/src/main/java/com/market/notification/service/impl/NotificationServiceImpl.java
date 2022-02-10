package com.market.notification.service.impl;

import com.market.notification.domain.Notification;
import com.market.notification.repository.NotificationRepository;
import com.market.notification.service.NotificationService;
import com.market.notification.service.RestNotificationCommand;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class NotificationServiceImpl implements NotificationService {
    NotificationRepository repository;

    @Override
    public void createNotification(RestNotificationCommand command) {
        repository.save(toNotification(command));
    }

    private Notification toNotification(RestNotificationCommand command) {
        return Notification.builder()
                .message(command.message())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
