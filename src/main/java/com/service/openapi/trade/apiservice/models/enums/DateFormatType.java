package com.service.openapi.trade.apiservice.models.enums;

import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DateFormatType {
    YYYY_MM_DD_DOT(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
    YYYY_MM_DD(DateTimeFormatter.ofPattern("yyyyMMdd")),
    ;

    private final DateTimeFormatter formatter;
}
