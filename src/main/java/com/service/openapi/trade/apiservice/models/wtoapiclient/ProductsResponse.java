package com.service.openapi.trade.apiservice.models.wtoapiclient;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductsResponse {
    private final String title;
    private final Integer status;
    private final String errors;
    private final String detail;

    private final String code;
    private final String name;
    private final String note;
    private final String productClassification;
    private final String codeUnique;
    private final Integer displayOrder;
    private final String hierarchy;
}
