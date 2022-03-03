package com.market.auction.service.impl;

import com.market.auction.domain.Auction;
import com.market.auction.domain.Category;
import com.market.auction.handler.exception.ItemNotAvailableException;
import com.market.auction.repository.AuctionRepository;
import com.market.auction.service.AuctionCommandService;
import com.market.clients.item.AvailableCheckResponse;
import com.market.clients.item.ItemClient;
import com.market.clients.notification.NotificationClient;
import com.market.clients.notification.RestNotificationCommand;
import com.market.rabbit.RabbitMQMessageProducer;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.market.auction.controller.AuctionController.RestAuctionCommand;

@Service
@Slf4j
@AllArgsConstructor
class AuctionCommandServiceImpl implements AuctionCommandService {
    private final AuctionRepository repository;
    private final ItemClient itemClient;
    private final RabbitMQMessageProducer producer;

    @Override
    @Transactional
    public void createAuction(RestAuctionCommand command) {
        log.info("Attempting to create auction with item id" +
                command.getItemId() + " and title " + command.getTitle());
        Auction auction = commandToAuction(command);
        AvailableCheckResponse response = itemClient.checkAvailability(command.getItemId());
        if (!response.isAvailable()) {
            throw new ItemNotAvailableException(command.getItemId());
        }
        Auction createdAuction = repository.saveAndFlush(auction);
        RestNotificationCommand notificationCommand = new RestNotificationCommand(
                auction.getItemId(), createdAuction.getId(), formatNotification(command, createdAuction));
        producer.publish(
                notificationCommand,
                "internal.exchange",
                "internal-notification.routing-key"
        );
    }

    private String formatNotification(RestAuctionCommand command, Auction createdAuction) {
        return String.format("Auction ID: %s contains Item ID: %s with price %s is valid to %s",
                createdAuction.getId(),command.getItemId(),command.getPrice(),command.getEndTime());
    }

    private Auction commandToAuction(RestAuctionCommand command) {
        return Auction.builder()
                .category(Category.NEW)
                .endTime(command.getEndTime())
                .itemId(command.getItemId())
                .quantity(command.getQuantity())
                .startTime(LocalDateTime.now())
                .price(command.getPrice())
                .title(command.getTitle())
                .build();
    }
}
