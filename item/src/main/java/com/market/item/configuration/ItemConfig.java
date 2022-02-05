package com.market.item.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class ItemConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
