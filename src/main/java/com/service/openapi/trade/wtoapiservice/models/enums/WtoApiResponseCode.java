package com.service.openapi.trade.wtoapiservice.models.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WtoApiResponseCode {
    CODE_SUCCESS(200, "success", WtoRequestStatusCode.CODE_COMPLETE),
    CODE_SUCCESS_(204, "no data", WtoRequestStatusCode.CODE_COMPLETE),
    CODE_BAD_REQUEST(400, "", WtoRequestStatusCode.CODE_FAIL),
    CODE_RESPONSE_EMPTY(5001, "response empty", WtoRequestStatusCode.CODE_FAIL),
    CODE_SUMMARY_EMPTY(5002, "summary empty", WtoRequestStatusCode.CODE_FAIL),
    CODE_DATASET_EMPTY(5003, "dataset empty", WtoRequestStatusCode.CODE_FAIL),
    CODE_ETC(5009, "unknown", WtoRequestStatusCode.CODE_FAIL)
    ;

    private final int statusCode;
    private final String detail;
    private final WtoRequestStatusCode requestStatusCode;

    public static WtoApiResponseCode getWtoApiResponseCodeByStatusCode(final int statusCode) {
        return Arrays.stream(WtoApiResponseCode.values())
                .filter(f -> f.getStatusCode() == statusCode)
                .findFirst().orElse(CODE_ETC);
    }
}
