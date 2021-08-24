package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_periods")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Periods extends EntityBaseAudit implements Serializable {
    @Id
    private String code;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "frequency_code", length = 20)
    private String frequencyCode;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Builder
    private Periods(final String code, final String name, final String description, final String frequencyCode, final Integer displayOrder) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.frequencyCode = frequencyCode;
        this.displayOrder = displayOrder;
    }
}
