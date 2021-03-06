package com.market.item.service.impl;

import com.market.clients.item.AvailableCheckResponse;
import com.market.item.domain.Item;
import com.market.item.repository.ItemRepository;
import com.market.item.service.ItemQueryService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
class ItemQueryServiceImpl implements ItemQueryService {
    private final ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }

    @Override
    public AvailableCheckResponse checkAvailability(Long id) {
        log.info("Checking availability of id: " + id);
        Boolean status = repository.findById(id)
                .map(Item::getIsAvailable)
                .orElse(false);
        return new AvailableCheckResponse(status);
    }

}
