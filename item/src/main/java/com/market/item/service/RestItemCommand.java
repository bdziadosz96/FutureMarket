package com.market.item.service;

import com.market.item.validator.ItemValidator;
import javax.validation.constraints.Size;

public record   RestItemCommand(@Size(min = 5, max = 10, groups = ItemValidator.class) String name,
                              String description, Boolean isAvailable) {

    //TODO: END VALIDATION

}
