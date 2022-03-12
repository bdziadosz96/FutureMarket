package com.market.auction.handler.exception;

public class ItemNotAvailableException extends RuntimeException {
    public ItemNotAvailableException(Long id) {
        super("Wrong id: " + id);
    }
}
