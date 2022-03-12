package com.market.auction.handler;

import com.market.auction.handler.exception.ItemNotAvailableException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class AuctionExceptionHandler {
    @ExceptionHandler(ItemNotAvailableException.class)
    public ResponseEntity<Object> handleItemNotAvailableException(ItemNotAvailableException exception) {
        final Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("erros", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
