package com.market.auction.service;

import static com.market.auction.controller.AuctionController.RestAuctionCommand;

public interface AuctionCommandService {
    void createAuction(RestAuctionCommand command);
}
