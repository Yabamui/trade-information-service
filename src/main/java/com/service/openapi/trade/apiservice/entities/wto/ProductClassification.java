package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_product_classifications")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@Getter
public class ProductClassification extends EntityBaseAudit implements Serializable {
    @Id
    private String code;

    private String name;

    @Builder
    private ProductClassification(final String code, final String name) {
        this.code = code;
        this.name = name;
    }
}
