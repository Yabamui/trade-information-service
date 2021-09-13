package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_years")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Years extends EntityBaseAudit implements Serializable {
    @Id
    @Column(name = "year")
    private Integer year;

    @Builder
    private Years(final Integer year) {
        this.year = year;
    }
}
