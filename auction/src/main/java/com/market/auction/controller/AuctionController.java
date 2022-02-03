package com.market.auction.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.market.auction.controller.serializer.MoneySerializer;
import com.market.auction.service.AuctionCommandService;
import com.market.auction.service.AuctionQueryService;
import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/auction")
@AllArgsConstructor
@Slf4j
public
class AuctionController {
    private final AuctionCommandService commandService;
    private final AuctionQueryService queryService;

    @ResponseStatus(ACCEPTED)
    @PostMapping
    public ResponseEntity<?> createAuction(@RequestBody RestAuctionCommand command) {
        commandService.createAuction(command);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemIdFromAuction(@PathVariable("id") Long itemId) {
        String message = queryService.getItem(itemId);
        return ResponseEntity.ok(message);
    }

    @Data
    public static class RestAuctionCommand {
        String title;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime endTime;
        Long itemId;
        Long quantity;
        @JsonProperty("amountOfMoney")
        @JsonSerialize(using = MoneySerializer.class)
        BigInteger price;
    }
}
