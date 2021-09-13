package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.IndicatorDataRequestPk;
import lombok.*;

@Entity
@Table(name = "wto_indicator_data_request")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Getter
@IdClass(IndicatorDataRequestPk.class)
public class IndicatorDataRequest extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "indicator_code", length = 20, nullable = false)
    private String indicatorCode;

    @Id
    @NonNull
    @Column(name = "period_code", length = 8, nullable = false)
    private String periodCode;

    @Column(name = "total_count", length = 20, nullable = false)
    private Integer totalCount;

    @Column(name = "response_status")
    private Integer responseStatus;

    @Column(name = "response_detail", length = 256)
    private String responseDetail;

    @Column(name = "status_code", length = 1)
    private String statusCode;

    @Builder
    private IndicatorDataRequest(final IndicatorDataRequestPk pk, final Integer totalCount, final Integer responseStatus,
                                 final String responseDetail, final String statusCode) {
        this.indicatorCode = pk.getIndicatorCode();
        this.periodCode = pk.getPeriodCode();
        this.totalCount = totalCount;
        this.responseStatus = responseStatus;
        this.responseDetail = responseDetail;
        this.statusCode = statusCode;
    }
}
