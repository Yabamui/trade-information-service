package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DataSet {
    @SerializedName("Name")
    private final String name;
    @SerializedName("Count")
    private final Integer count;
    @SerializedName("TotalCount")
    private final Integer totalCount;
}
