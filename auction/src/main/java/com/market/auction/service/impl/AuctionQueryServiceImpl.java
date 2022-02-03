package com.market.auction.service.impl;

import com.market.auction.repository.AuctionRepository;
import com.market.auction.service.AuctionQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AuctionQueryServiceImpl implements AuctionQueryService {
    private final AuctionRepository repository;

    @Override
    public String getItem(Long id) {
        return repository.findByItemId(id)
                .map(x -> "Item ID: " + x)
                .orElse("Not found");
    }
}
