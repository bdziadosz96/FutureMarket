package com.market.auction.service;

import com.market.auction.controller.AuctionController;

import static com.market.auction.controller.AuctionController.*;

public interface AuctionCommandService {
    void createAuction(RestAuctionCommand command);
}
