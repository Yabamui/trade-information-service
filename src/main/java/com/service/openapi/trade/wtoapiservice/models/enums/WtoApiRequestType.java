package com.service.openapi.trade.wtoapiservice.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WtoApiRequestType {
    TYPE_ENGLISH("1"),
    TYPE_ALL("all"),
    TYPE_DEFAULT("default"),
    TYPE_FORMAT("json"),
    TYPE_MODE("full"),
    TYPE_HEADER_STYLE("H")
    ;

    private final String value;
}
