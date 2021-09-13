package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DataSummaryResponse {
    @SerializedName("QueryParameters")
    private final String queryParameters;
    @SerializedName("DataSet")
    private final List<DataSet> dataSet;
    @SerializedName("Started")
    private final String started;
    @SerializedName("Finished")
    private final String finished;
    @SerializedName("DurationSeconds")
    private final String durationSeconds;
}
