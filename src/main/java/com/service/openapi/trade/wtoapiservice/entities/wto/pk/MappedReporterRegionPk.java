package com.service.openapi.trade.wtoapiservice.entities.wto.pk;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MappedReporterRegionPk implements Serializable {
    private String regionCode;

    private String reporterCode;

    @Builder
    private MappedReporterRegionPk(final String regionCode, final String reporterCode) {
        this.regionCode = regionCode;
        this.reporterCode = reporterCode;
    }
}
