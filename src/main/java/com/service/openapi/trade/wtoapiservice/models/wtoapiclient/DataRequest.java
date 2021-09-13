package com.service.openapi.trade.wtoapiservice.models.wtoapiclient;

import com.service.openapi.trade.wtoapiservice.models.enums.WtoApiRequestType;
import feign.Param;
import lombok.Builder;

@Builder
public class DataRequest {
    private final String language;
    private String indicatorCode;
    private final String economicReporter;
    private final String economicPartner;
    private String periodTime;
    private final String productClassificationCode;
    private final boolean isSubProductClassificationCode;
    private final String format;
    private final String mode;
    private final String decimals;
    private int offset;
    private final int limited;
    private final String headerStyle;
    private final boolean isMetadata;

    @Param("lang")
    public String getLanguage() {
        return this.language;
    }

    @Param("i")
    public String getIndicatorCode() {
        return this.indicatorCode;
    }

    @Param("r")
    public String getEconomicReporter() {
        return this.economicReporter;
    }

    @Param("p")
    public String getEconomicPartner() {
        return this.economicPartner;
    }

    @Param("ps")
    public String getPeriodTime() {
        return this.periodTime;
    }

    @Param("pc")
    public String getProductClassificationCode() {
        return this.productClassificationCode;
    }

    @Param("spc")
    public boolean isSubProductClassificationCode() {
        return this.isSubProductClassificationCode;
    }

    @Param("fmt")
    public String getFormat() {
        return this.format;
    }

    @Param("mode")
    public String getMode() {
        return this.mode;
    }

    @Param("dec")
    public String getDecimals() {
        return this.decimals;
    }

    @Param("off")
    public int getOffset() {
        return this.offset;
    }

    @Param("max")
    public int getLimited() {
        return this.limited;
    }

    @Param("head")
    public String getHeaderStyle() {
        return this.headerStyle;
    }

    @Param("meta")
    public boolean isMetadata() {
        return this.isMetadata;
    }

    public void updateOffset(final int offset) {
        this.offset = offset;
    }

    public void updateRequestValue(final String indicator, final String periodTime) {
        this.indicatorCode = indicator;
        this.periodTime = periodTime;
    }

    public static DataRequest getInstance(final String indicatorCode, final String periodTime, final int offset, final int limited) {
        return DataRequest.builder()
                .language(WtoApiRequestType.TYPE_ENGLISH.getValue())
                .indicatorCode(indicatorCode)
                .economicReporter(WtoApiRequestType.TYPE_ALL.getValue())
                .economicPartner(WtoApiRequestType.TYPE_DEFAULT.getValue())
                .periodTime(periodTime)
                .productClassificationCode(WtoApiRequestType.TYPE_DEFAULT.getValue())
                .isSubProductClassificationCode(false)
                .format(WtoApiRequestType.TYPE_FORMAT.getValue())
                .mode(WtoApiRequestType.TYPE_MODE.getValue())
                .decimals(WtoApiRequestType.TYPE_DEFAULT.getValue())
                .offset(offset)
                .limited(limited)
                .headerStyle(WtoApiRequestType.TYPE_HEADER_STYLE.getValue())
                .isMetadata(true)
                .build();
    }
}
