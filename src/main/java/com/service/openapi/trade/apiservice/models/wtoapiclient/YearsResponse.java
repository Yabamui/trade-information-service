package com.service.openapi.trade.apiservice.models.wtoapiclient;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class YearsResponse {
    private final String title;
    private final Integer status;
    private final String errors;
    private final String detail;

    private final int year;
}
