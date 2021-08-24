package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_territory_regions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@Getter
public class TerritoryRegions extends EntityBaseAudit implements Serializable {
    @Id
    private String code;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Builder
    private TerritoryRegions(final String code, final String name, final Integer displayOrder) {
        this.code = code;
        this.name = name;
        this.displayOrder = displayOrder;
    }
}
