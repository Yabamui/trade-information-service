package com.service.openapi.trade.apiservice.models.wtoapiclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MetadataResponse {
    private final String errors;
    private final String type;
    private final String title;
    private final Integer status;
    private final String detail;
    private final String instance;
    private final String extensions;

    @JsonProperty("metadataCategoryCode")
    private final String metadataCategoryCode;
    @JsonProperty("indicatorCategoryCode")
    private final String indicatorCategoryCode;
    @JsonProperty("indicatorCode")
    private final String indicatorCode;
    @JsonProperty("reportingEconomyCode")
    private final String reportingEconomyCode;
    @JsonProperty("partnerEconomyCode")
    private final String partnerEconomyCode;
    @JsonProperty("productOrSectorClassificationCode")
    private final String productOrSectorClassificationCode;
    @JsonProperty("productOrSectorCode")
    private final String productOrSectorCode;
    @JsonProperty("periodCode")
    private final String periodCode;
    @JsonProperty("frequencyCode")
    private final String frequencyCode;
    @JsonProperty("unitCode")
    private final String unitCode;
    @JsonProperty("value")
    private final Integer value;
}
