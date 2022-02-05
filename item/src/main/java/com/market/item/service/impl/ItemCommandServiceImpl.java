package com.market.item.service.impl;

import com.market.item.domain.Item;
import com.market.item.repository.ItemRepository;
import com.market.item.service.ItemCommandService;
import com.market.item.service.RestItemCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ItemCommandServiceImpl implements ItemCommandService {
    private final ItemRepository repository;

    @Override
    public void createItem(RestItemCommand command) {
        repository.saveAndFlush(new Item(
                command.name(),
                command.description(),
                command.isAvailable()
        ));
    }
}
