package com.service.openapi.trade.apiservice.entities.wto.pk;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MappedPartnerRegionPk implements Serializable {
    private String regionCode;

    private String partnerCode;

    @Builder
    private MappedPartnerRegionPk(final String regionCode, final String partnerCode) {
        this.regionCode = regionCode;
        this.partnerCode = partnerCode;
    }
}
