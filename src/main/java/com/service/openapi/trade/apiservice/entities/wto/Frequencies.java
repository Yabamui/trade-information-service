package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_frequencies")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Frequencies extends EntityBaseAudit implements Serializable {
    @Id
    private String code;

    private String name;

    @Builder
    private Frequencies(final String code, final String name) {
        this.code = code;
        this.name = name;
    }
}
