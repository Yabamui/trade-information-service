package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.apiservice.models.wtoapiclient.IndicatorResponse;
import lombok.*;

@Entity
@Table(name = "wto_indicators")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@Getter
public class Indicators extends EntityBaseAudit implements Serializable {
    @Id
    @Column(name = "code", length = 40, nullable = false)
    private String code;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "category_code", length = 20)
    private String categoryCode;

    @Column(name = "category_label", length = 256)
    private String categoryLabel;

    @Column(name = "subcategory_code", length = 20)
    private String subcategoryCode;

    @Column(name = "subcategory_label", length = 256)
    private String subcategoryLabel;

    @Column(name = "unit_code", length = 20)
    private String unitCode;

    @Column(name = "unit_label", length = 256)
    private String unitLabel;

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @Column(name = "end_year", nullable = false)
    private Integer endYear;

    @Column(name = "frequency_code", length = 20)
    private String frequencyCode;

    @Column(name = "frequency_label", length = 256)
    private String frequencyLabel;

    @Column(name = "number_reporters")
    private Integer numberReporters;

    @Column(name = "number_partners")
    private Integer numberPartners;

    @Column(name = "product_sector_classification_code", length = 20)
    private String productSectorClassificationCode;

    @Column(name = "product_sector_classification_label", length = 256)
    private String productSectorClassificationLabel;

    @Column(name = "has_metadata", length = 20)
    private String hasMetadata;

    @Column(name = "number_decimals")
    private Integer numberDecimals;

    @Column(name = "number_datapoints")
    private Integer numberDatapoints;

    @Column(name = "update_frequency", length = 128)
    private String updateFrequency;

    @Column(name = "description", length = 256)
    private String description;

    @Builder
    private Indicators(final String code, final String name, final String categoryCode, final String categoryLabel,
                       final String subcategoryCode, final String subcategoryLabel, final String unitCode,
                       final String unitLabel, final Integer startYear, final Integer endYear, final String frequencyCode,
                       final String frequencyLabel, final Integer numberReporters, final Integer numberPartners,
                       final String productSectorClassificationCode, final String productSectorClassificationLabel,
                       final String hasMetadata, final Integer numberDecimals, final Integer numberDatapoints,
                       final String updateFrequency, final String description) {
        this.code = code;
        this.name = name;
        this.categoryCode = categoryCode;
        this.categoryLabel = categoryLabel;
        this.subcategoryCode = subcategoryCode;
        this.subcategoryLabel = subcategoryLabel;
        this.unitCode = unitCode;
        this.unitLabel = unitLabel;
        this.startYear = startYear;
        this.endYear = endYear;
        this.frequencyCode = frequencyCode;
        this.frequencyLabel = frequencyLabel;
        this.numberReporters = numberReporters;
        this.numberPartners = numberPartners;
        this.productSectorClassificationCode = productSectorClassificationCode;
        this.productSectorClassificationLabel = productSectorClassificationLabel;
        this.hasMetadata = hasMetadata;
        this.numberDecimals = numberDecimals;
        this.numberDatapoints = numberDatapoints;
        this.updateFrequency = updateFrequency;
        this.description = description;
    }

    public static Indicators getInstance(final IndicatorResponse response) {
        return Indicators.builder()
                .code(response.getCode())
                .name(response.getName())
                .categoryCode(response.getCategoryCode())
                .categoryLabel(response.getCategoryLabel())
                .subcategoryCode(response.getSubcategoryCode())
                .subcategoryLabel(response.getSubcategoryLabel())
                .unitCode(response.getUnitCode())
                .unitLabel(response.getUnitLabel())
                .startYear(response.getStartYear())
                .endYear(response.getEndYear())
                .frequencyCode(response.getFrequencyCode())
                .frequencyLabel(response.getFrequencyLabel())
                .numberReporters(response.getNumberReporters())
                .numberPartners(response.getNumberPartners())
                .productSectorClassificationCode(response.getProductSectorClassificationCode())
                .productSectorClassificationLabel(response.getProductSectorClassificationLabel())
                .hasMetadata(response.getHasMetadata())
                .numberDecimals(response.getNumberDecimals())
                .numberDatapoints(response.getNumberDatapoints())
                .updateFrequency(response.getUpdateFrequency())
                .description(response.getDescription())
                .build();
    }

}
