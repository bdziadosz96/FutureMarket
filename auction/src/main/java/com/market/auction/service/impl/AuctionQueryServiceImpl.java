package com.market.auction.service.impl;

import com.market.auction.domain.Auction;
import com.market.auction.repository.AuctionRepository;
import com.market.auction.service.AuctionQueryService;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class AuctionQueryServiceImpl implements AuctionQueryService {
    private final AuctionRepository repository;

    @Override
    public Set<Auction> findAll() {
        return new HashSet<>(repository
                .findAll());
    }
}
