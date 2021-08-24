package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "wto_economic_partners")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class EconomicPartners extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "code", length = 20)
    private String code;
    @Column(name = "name", length = 256)
    private String name;
    @Column(name = "iso_3A", length = 256)
    private String iso3A;
    @Column(name = "display_order")
    private Integer displayOrder;

    @Builder
    private EconomicPartners(final String code, final String name, final String iso3A, final Integer displayOrder) {
        this.code = code;
        this.name = name;
        this.iso3A = iso3A;
        this.displayOrder = displayOrder;
    }
}
