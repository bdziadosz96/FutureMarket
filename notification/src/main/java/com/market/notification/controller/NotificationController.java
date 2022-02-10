package com.market.notification.controller;

import com.market.notification.service.NotificationService;
import com.market.notification.service.RestNotificationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
class NotificationController {
    private NotificationService service;

    @PostMapping
    ResponseEntity<String> createNotification(@RequestBody RestNotificationCommand command) {
        service.createNotification(command);
        return ResponseEntity.ok().build();
    }
}
