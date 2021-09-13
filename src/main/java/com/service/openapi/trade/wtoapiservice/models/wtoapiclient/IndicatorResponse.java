package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class IndicatorResponse {
    @JsonProperty("code")
    private final String code;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("categoryCode")
    private final String categoryCode;
    @JsonProperty("categoryLabel")
    private final String categoryLabel;
    @JsonProperty("subcategoryCode")
    private final String subcategoryCode;
    @JsonProperty("subcategoryLabel")
    private final String subcategoryLabel;
    @JsonProperty("unitCode")
    private final String unitCode;
    @JsonProperty("unitLabel")
    private final String unitLabel;
    @JsonProperty("startYear")
    private final Integer startYear;
    @JsonProperty("endYear")
    private final Integer endYear;
    @JsonProperty("frequencyCode")
    private final String frequencyCode;
    @JsonProperty("frequencyLabel")
    private final String frequencyLabel;
    @JsonProperty("numberReporters")
    private final Integer numberReporters;
    @JsonProperty("numberPartners")
    private final Integer numberPartners;
    @JsonProperty("productSectorClassificationCode")
    private final String productSectorClassificationCode;
    @JsonProperty("productSectorClassificationLabel")
    private final String productSectorClassificationLabel;
    @JsonProperty("hasMetadata")
    private final String hasMetadata;
    @JsonProperty("numberDecimals")
    private final Integer numberDecimals;
    @JsonProperty("numberDatapoints")
    private final Integer numberDatapoints;
    @JsonProperty("updateFrequency")
    private final String updateFrequency;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("sortOrder")
    private final Integer sortOrder;
}
