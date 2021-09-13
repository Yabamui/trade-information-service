package com.service.openapi.trade.wtoapiservice.entities.wto.pk;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IndicatorDataRequestQueuePk implements Serializable {
    private String indicatorCode;

    private String periodCode;

    private Integer offset;

    @Builder
    private IndicatorDataRequestQueuePk(final String indicatorCode, final String periodCode, final Integer offset) {
        this.indicatorCode = indicatorCode;
        this.periodCode = periodCode;
        this.offset = offset;
    }
}
