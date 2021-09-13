package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_topics")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Topics extends EntityBaseAudit implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @Builder
    private Topics(final Integer id, final String name, final Integer sortOrder) {
        this.id = id;
        this.name = name;
        this.sortOrder = sortOrder;
    }
}
