package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.MappedReporterRegionPk;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "wto_mapped_reporter_region")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@IdClass(MappedReporterRegionPk.class)
public class MappedReporterRegion extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "region_code", length = 20)
    private String regionCode;

    @Id
    @NonNull
    @Column(name = "reporter_code", length = 20)
    private String reporterCode;

    @Builder
    private MappedReporterRegion(final MappedReporterRegionPk pk) {
        this.regionCode = pk.getRegionCode();
        this.reporterCode = pk.getReporterCode();
    }
}
