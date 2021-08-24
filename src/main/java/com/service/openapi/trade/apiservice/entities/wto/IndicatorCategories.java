package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_indicator_categories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class IndicatorCategories extends EntityBaseAudit implements Serializable {
    @Id
    private String code;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "parent_code", length = 20)
    private String parentCode;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Builder
    private IndicatorCategories(final String code, final String name, final String parentCode, final Integer sortOrder) {
        this.code = code;
        this.name = name;
        this.parentCode = parentCode;
        this.sortOrder = sortOrder;
    }
}
