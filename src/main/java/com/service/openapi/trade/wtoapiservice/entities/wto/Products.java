package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "wto_products", indexes = {
        @Index(name = "wto_products_code", columnList = "code", unique = false),
        @Index(name = "wto_products_product_classification", columnList = "product_classification", unique = false),
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Products extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "code_unique", length = 40)
    private String codeUnique;
    @NonNull
    @Column(name = "code", length = 20)
    private String code;
    @Column(name = "name", length = 512)
    private String name;
    @Column(name = "note", length = 512)
    private String note;
    @NonNull
    @Column(name = "product_classification", length = 20)
    private String productClassification;
    @Column(name = "display_order")
    private Integer displayOrder;
    @Column(name = "hierarchy", length = 8)
    private String hierarchy;

    @Builder
    private Products(final String codeUnique, final String code, final String name, final String note,
                     final String productClassification, final Integer displayOrder, final String hierarchy) {
        this.codeUnique = codeUnique;
        this.code = code;
        this.name = name;
        this.note = note;
        this.productClassification = productClassification;
        this.displayOrder = displayOrder;
        this.hierarchy = hierarchy;
    }
}
