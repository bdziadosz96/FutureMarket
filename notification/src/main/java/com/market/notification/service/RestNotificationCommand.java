package com.market.notification.service;

public record RestNotificationCommand(Long itemId, Long auctionId, String message) {
}
