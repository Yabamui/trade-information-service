package com.service.openapi.trade.wtoapiservice.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WtoRequestStatusCode {
    CODE_INIT("I"),
    CODE_COMPLETE("C"),
    CODE_FAIL("F"),
    ;

    private final String code;
}
