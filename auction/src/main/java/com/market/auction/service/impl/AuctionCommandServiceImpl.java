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
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.market.auction.controller.AuctionController.RestAuctionCommand;

@Service
@AllArgsConstructor
class AuctionCommandServiceImpl implements AuctionCommandService {
    private final AuctionRepository repository;
    private final ItemClient itemClient;
    private final NotificationClient notificationClient;

    @Override
    @Transactional
    public void createAuction(RestAuctionCommand command) {
        Auction auction = commandToAuction(command);
        AvailableCheckResponse response = itemClient.checkAvailability(auction.getItemId());
        if (!response.isAvailable()) {
            throw new ItemNotAvailableException(auction.getItemId());
        }
        Auction createdAuction = repository.saveAndFlush(auction);
        notificationClient.createNotification(new RestNotificationCommand(
                auction.getItemId(), createdAuction.getId(), String.format("%d new auction: %d ",
                auction.getItemId(), createdAuction.getItemId())
        ));
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
