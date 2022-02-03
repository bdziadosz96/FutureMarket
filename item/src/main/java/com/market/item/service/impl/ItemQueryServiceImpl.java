package com.market.item.service.impl;

import com.market.item.domain.Item;
import com.market.item.repository.ItemRepository;
import com.market.item.service.ItemQueryService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ItemQueryServiceImpl implements ItemQueryService {
    private final ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }
}
