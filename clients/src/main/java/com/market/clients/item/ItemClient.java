package com.market.clients.item;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("item")
public interface ItemClient {
    @GetMapping(path = "item/{id}")
    AvailableCheckResponse checkAvailability(@PathVariable("id") Long itemId);
}