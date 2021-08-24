package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.apiservice.entities.wto.pk.MappedPartnerRegionPk;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "wto_mapped_partner_region")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@IdClass(MappedPartnerRegionPk.class)
public class MappedPartnerRegion extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "region_code", length = 20)
    private String regionCode;

    @Id
    @NonNull
    @Column(name = "partner_code", length = 20)
    private String partnerCode;

    @Builder
    private MappedPartnerRegion(final MappedPartnerRegionPk pk) {
        this.regionCode = pk.getRegionCode();
        this.partnerCode = pk.getPartnerCode();
    }
}
