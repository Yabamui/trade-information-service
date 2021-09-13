package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.IndicatorDataRequestQueue;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.IndicatorDataRequestQueuePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorDataRequestQueueRepository extends JpaRepository<IndicatorDataRequestQueue, IndicatorDataRequestQueuePk> {
}
