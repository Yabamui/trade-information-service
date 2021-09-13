package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TimeseriesData {
    @SerializedName("IndicatorCategoryCode")
    private final String indicatorCategoryCode;
    @SerializedName("IndicatorCategory")
    private final String indicatorCategory;
    @SerializedName("IndicatorCode")
    private final String indicatorCode;
    @SerializedName("Indicator")
    private final String indicator;
    @SerializedName("ReportingEconomyCode")
    private final String economicReporterCode;
    @SerializedName("ReportingEconomy")
    private final String economicReporter;
    @SerializedName("PartnerEconomyCode")
    private final String economicPartnerCode;
    @SerializedName("PartnerEconomy")
    private final String economicPartner;
    @SerializedName("ProductOrSectorClassificationCode")
    private final String productClassificationCode;
    @SerializedName("ProductOrSectorClassification")
    private final String productClassification;
    @SerializedName("ProductOrSectorCode")
    private final String productCode;
    @SerializedName("ProductOrSector")
    private final String product;
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
    private final String value;
}
