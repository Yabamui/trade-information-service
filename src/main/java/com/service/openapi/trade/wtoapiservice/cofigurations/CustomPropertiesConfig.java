package com.service.openapi.trade.wtoapiservice.cofigurations;

import com.service.openapi.trade.wtoapiservice.models.customproperties.WtoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomPropertiesConfig {
    @Bean
    @ConfigurationProperties(prefix = "wto")
    public WtoProperties wtoProperties() {
        return WtoProperties.builder().build();
    }
}
