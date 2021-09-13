package com.service.openapi.trade.wtoapiservice.cofigurations;

import com.service.openapi.trade.wtoapiservice.models.customproperties.WtoProperties;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WtoApiClientConfig {
    private final WtoProperties wtoProperties;

    @Bean
    public RequestInterceptor requestTemplate() {
        return requestTemplate -> requestTemplate
                .header("Ocp-Apim-Subscription-Key", wtoProperties.getPrimaryKey());
    }
}
