package com.market.item.controller;

import com.market.clients.item.AvailableCheckResponse;
import com.market.item.domain.Item;
import com.market.item.service.ItemCommandService;
import com.market.item.service.ItemQueryService;
import com.market.item.service.RestItemCommand;
import com.market.item.validator.ItemValidator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping("/item")
@AllArgsConstructor
class ItemController {
    private ItemCommandService commandService;
    private ItemQueryService queryService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@Validated(ItemValidator.class) @RequestBody RestItemCommand command) {
        log.info("Attempting to register " + command.name() + " - " + command.description() + " - " + command.isAvailable());
        commandService.createItem(command);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllItems() {
        log.info("Request of finding every items in application");
        List<Item> all = queryService.findAll();
        return ResponseEntity.accepted().body(all);
    }

    @GetMapping("/{id}")
    public AvailableCheckResponse checkAvailability(@PathVariable("id") Long itemId) {
        return queryService.checkAvailability(itemId);
    }


}
