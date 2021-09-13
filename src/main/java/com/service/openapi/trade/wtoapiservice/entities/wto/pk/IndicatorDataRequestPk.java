package com.service.openapi.trade.wtoapiservice.entities.wto.pk;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IndicatorDataRequestPk implements Serializable {
    private String indicatorCode;

    private String periodCode;

    @Builder
    private IndicatorDataRequestPk(final String indicatorCode, final String periodCode) {
        this.indicatorCode = indicatorCode;
        this.periodCode = periodCode;
    }
}
