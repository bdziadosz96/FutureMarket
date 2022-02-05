package com.market.item.service;

import com.market.item.controller.AvailableCheckResponse;
import com.market.item.domain.Item;
import java.util.List;

public interface ItemQueryService {
    List<Item> findAll();

    AvailableCheckResponse checkAvailability(Long id);
}
