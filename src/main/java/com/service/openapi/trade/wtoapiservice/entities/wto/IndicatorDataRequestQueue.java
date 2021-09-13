package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.IndicatorDataRequestQueuePk;
import lombok.*;

@Entity
@Table(name = "wto_indicator_data_request_queue")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Getter
@IdClass(IndicatorDataRequestQueuePk.class)
public class IndicatorDataRequestQueue extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "indicator_code", length = 20, nullable = false)
    private String indicatorCode;

    @Id
    @NonNull
    @Column(name = "period_code", length = 8, nullable = false)
    private String periodCode;

    @Id
    @NonNull
    @Column(name = "offset", nullable = false)
    private Integer offset;

    @Column(name = "limited")
    private Integer limited;

    @Column(name = "response_status")
    private Integer responseStatus;

    @Column(name = "response_detail", length = 256)
    private String responseDetail;

    @Column(name = "status_code", length = 1)
    private String statusCode;

    @Builder
    private IndicatorDataRequestQueue(final IndicatorDataRequestQueuePk pk, final Integer limited,
                                      final Integer responseStatus, final String responseDetail, final String statusCode) {
        this.indicatorCode = pk.getIndicatorCode();
        this.periodCode = pk.getPeriodCode();
        this.offset = pk.getOffset();
        this.limited = limited;
        this.responseStatus = responseStatus;
        this.responseDetail = responseDetail;
        this.statusCode = statusCode;
    }
}
