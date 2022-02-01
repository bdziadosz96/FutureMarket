package com.market.item.controller;

import com.market.item.service.ItemCommandService;
import com.market.item.service.RestItemCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping("/item")
@AllArgsConstructor
class ItemCommandController {
    private ItemCommandService commandService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody RestItemCommand command) {
        log.info("Attempting to register " + command.name() + " - " + command.description());
        commandService.createItem(command);
    }


}
