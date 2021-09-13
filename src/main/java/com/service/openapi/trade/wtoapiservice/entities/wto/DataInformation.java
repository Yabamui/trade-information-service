package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import lombok.*;

@Entity
@Table(name = "wto_data_information")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@Getter
public class DataInformation extends EntityBaseAudit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "indicator_category_code", length = 20)
    private String indicatorCategoryCode;

    @Column(name = "indicator_code", length = 20)
    private String indicatorCode;

    @Column(name = "economic_reporter_code", length = 20)
    private String economicReporterCode;

    @Column(name = "economic_partner_code", length = 20)
    private String economicPartnerCode;

    @Column(name = "product_classification_code", length = 20)
    private String productClassificationCode;

    @Column(name = "product_code", length = 20)
    private String productCode;

    @Column(name = "period_code", length = 20)
    private String periodCode;

    @Column(name = "frequency_code", length = 20)
    private String frequencyCode;

    @Column(name = "unit_code", length = 20)
    private String unitCode;

    @Column(name = "year")
    private Integer year;

    @Column(name = "value_flag_code", length = 20)
    private String valueFlagCode;

    @Column(name = "text_value", length = 256)
    private String textValue;

    @Column(name = "value", length = 20)
    private String value;

    @Builder
    private DataInformation(final String indicatorCategoryCode, final String indicatorCode, final String economicReporterCode,
                            final String economicPartnerCode, final String productClassificationCode, final String productCode,
                            final String periodCode, final String frequencyCode, final String unitCode, final Integer year,
                            final String valueFlagCode, final String textValue, final String value) {
        this.indicatorCategoryCode = indicatorCategoryCode;
        this.indicatorCode = indicatorCode;
        this.economicReporterCode = economicReporterCode;
        this.economicPartnerCode = economicPartnerCode;
        this.productClassificationCode = productClassificationCode;
        this.productCode = productCode;
        this.periodCode = periodCode;
        this.frequencyCode = frequencyCode;
        this.unitCode = unitCode;
        this.year = year;
        this.valueFlagCode = valueFlagCode;
        this.textValue = textValue;
        this.value = value;
    }
}
