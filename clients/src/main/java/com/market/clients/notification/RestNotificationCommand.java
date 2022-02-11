package com.market.clients.notification;

public record RestNotificationCommand(Long itemId, Long auctionId, String message) {
}
