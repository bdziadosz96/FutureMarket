package com.market.vaadin;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableVaadin
@Theme(value = "mymarket")
@PWA(name = "MyMarket", shortName = "MyMarket", offlineResources = {"images/logo.png"})
public class MarketApplication implements AppShellConfigurator {
    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

}
