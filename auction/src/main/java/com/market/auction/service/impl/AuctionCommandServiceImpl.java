package com.market.auction.service.impl;

import com.market.auction.domain.Auction;
import com.market.auction.domain.Category;
import com.market.auction.repository.AuctionRepository;
import com.market.auction.service.AuctionCommandService;
import com.market.clients.item.AvailableCheckResponse;
import com.market.clients.item.ItemClient;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.market.auction.controller.AuctionController.RestAuctionCommand;

@Service
@AllArgsConstructor
class AuctionCommandServiceImpl implements AuctionCommandService {
    private final AuctionRepository repository;
    private final ItemClient client;

    @Override
    public void createAuction(RestAuctionCommand command) {
        Auction auction = commandToAuction(command);
        AvailableCheckResponse response = client.checkAvailability(auction.getItemId());
        if (!response.isAvailable()) {
            throw new IllegalStateException("Wrong id");
        }
        repository.save(auction);
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
