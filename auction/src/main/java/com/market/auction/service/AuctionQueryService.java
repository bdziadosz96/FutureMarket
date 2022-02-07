package com.market.auction.service;

import com.market.auction.domain.Auction;
import java.util.Set;

public interface AuctionQueryService {
    Set<Auction> findAll();
}
