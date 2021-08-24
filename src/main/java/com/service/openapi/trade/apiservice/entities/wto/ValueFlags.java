package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_value_flags")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class ValueFlags extends EntityBaseAudit implements Serializable {
    @Id
    private String code;

    @Column(name = "description", length = 256)
    private String description;

    @Builder
    private ValueFlags(final String code, final String description) {
        this.code = code;
        this.description = description;
    }
}
