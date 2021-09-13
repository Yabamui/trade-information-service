package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TopicsResponse {
    private final String title;
    private final Integer status;
    private final String errors;
    private final String detail;

    private final Integer id;
    private final String name;
    private final Integer sortOrder;
}
