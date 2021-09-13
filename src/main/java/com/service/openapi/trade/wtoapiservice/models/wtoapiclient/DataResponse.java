package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DataResponse {
    private final String title;
    private final Integer status;
    private final String errors;
    private final String detail;

    @SerializedName("Dataset")
    private final List<TimeseriesData> dataset;
    @SerializedName("Summary")
    private final List<DataSummaryResponse> summary;
}
