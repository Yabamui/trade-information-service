package com.service.openapi.trade.apiservice.models.wtoapiclient;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EconomicGroupsResponse {
    private final String title;
    private final Integer status;
    private final String errors;
    private final String detail;

    private final String code;
    private final String name;
    private final Integer displayOrder;
}
