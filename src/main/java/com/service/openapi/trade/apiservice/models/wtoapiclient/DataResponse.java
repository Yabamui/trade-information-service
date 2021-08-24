package com.service.openapi.trade.apiservice.models.wtoapiclient;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DataResponse {
    @SerializedName("Dataset")
    private final List<TimeseriseData> dataset;
}
