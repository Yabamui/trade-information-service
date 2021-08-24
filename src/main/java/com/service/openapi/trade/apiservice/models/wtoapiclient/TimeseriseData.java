package com.service.openapi.trade.apiservice.models.wtoapiclient;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TimeseriseData {
    @SerializedName("IndicatorCategoryCode")
    private final String indicatorCategoryCode;
    @SerializedName("IndicatorCategory")
    private final String indicatorCategory;
    @SerializedName("IndicatorCode")
    private final String indicatorCode;
    @SerializedName("Indicator")
    private final String indicator;
    @SerializedName("ReportingEconomyCode")
    private final String reportingEconomyCode;
    @SerializedName("ReportingEconomy")
    private final String reportingEconomy;
    @SerializedName("PartnerEconomyCode")
    private final String partnerEconomyCode;
    @SerializedName("PartnerEconomy")
    private final String partnerEconomy;
    @SerializedName("ProductOrSectorClassificationCode")
    private final String productOrSectorClassificationCode;
    @SerializedName("ProductOrSectorClassification")
    private final String productOrSectorClassification;
    @SerializedName("ProductOrSectorCode")
    private final String productOrSectorCode;
    @SerializedName("ProductOrSector")
    private final String productOrSector;
    @SerializedName("PeriodCode")
    private final String periodCode;
    @SerializedName("Period")
    private final String period;
    @SerializedName("FrequencyCode")
    private final String frequencyCode;
    @SerializedName("Frequency")
    private final String frequency;
    @SerializedName("UnitCode")
    private final String unitCode;
    @SerializedName("Unit")
    private final String unit;
    @SerializedName("Year")
    private final Integer year;
    @SerializedName("ValueFlagCode")
    private final String valueFlagCode;
    @SerializedName("ValueFlag")
    private final String valueFlag;
    @SerializedName("TextValue")
    private final String textValue;
    @SerializedName("Value")
    private final Integer value;
}
