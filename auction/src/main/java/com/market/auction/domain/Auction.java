package com.market.auction.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;

class Auction extends BaseEntity{
    private String title;
    private LocalDateTime endTime;
    private
    @CreatedDate
    private LocalDateTime startTime;
}
