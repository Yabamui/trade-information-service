package com.service.openapi.trade.wtoapiservice.entities.wto.pk;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MappedPartnerGroupPk implements Serializable {
    private String groupCode;

    private String partnerCode;

    @Builder
    private MappedPartnerGroupPk(final String groupCode, final String partnerCode) {
        this.groupCode = groupCode;
        this.partnerCode = partnerCode;
    }
}
