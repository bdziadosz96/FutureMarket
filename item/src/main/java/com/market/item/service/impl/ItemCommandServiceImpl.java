package com.market.item.service.impl;

import com.market.item.domain.Item;
import com.market.item.repository.ItemRepository;
import com.market.item.service.ItemCommandService;
import com.market.item.service.RestItemCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
class ItemCommandServiceImpl implements ItemCommandService {
    private final ItemRepository repository;

    @Override
    public void createItem(RestItemCommand command) {
        log.info("Add new item " + command.description() + " :: " + command.name());
        repository.save(new Item(
                command.name(),
                command.description(),
                command.isAvailable()
        ));
    }
}
