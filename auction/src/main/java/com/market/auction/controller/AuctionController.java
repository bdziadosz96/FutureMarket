package com.market.auction.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.market.auction.service.AuctionCommandService;
import com.market.auction.service.AuctionQueryService;
import com.market.auction.validator.AuctionValidator;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/auction")
@AllArgsConstructor
@Slf4j
public class AuctionController {
    private final AuctionCommandService commandService;
    private final AuctionQueryService queryService;

    @ResponseStatus(ACCEPTED)
    @PostMapping
    public ResponseEntity<?> createAuction(@Validated(AuctionValidator.class)
                                               @RequestBody RestAuctionCommand command) {
        commandService.createAuction(command);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    @ResponseStatus(OK)
    public ResponseEntity<Set<?>> getAllAuctions() {
        return ResponseEntity.ok(queryService.findAll());
    }

    @Data
    public static class RestAuctionCommand {
        @Size(min = 5, max = 255, groups = AuctionValidator.class)
        String title;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime endTime;
        @NotNull
        Long itemId;
        @Min(1)
        Long quantity;
        BigDecimal price;
    }
}
