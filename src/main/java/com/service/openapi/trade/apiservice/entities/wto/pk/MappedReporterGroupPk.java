package com.service.openapi.trade.apiservice.entities.wto.pk;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MappedReporterGroupPk implements Serializable {
    private String groupCode;

    private String reporterCode;

    @Builder
    private MappedReporterGroupPk(final String groupCode, final String reporterCode) {
        this.groupCode = groupCode;
        this.reporterCode = reporterCode;
    }
}
