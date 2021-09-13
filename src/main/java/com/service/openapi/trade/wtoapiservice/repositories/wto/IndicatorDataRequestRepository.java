package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.IndicatorDataRequest;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.IndicatorDataRequestPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorDataRequestRepository extends JpaRepository<IndicatorDataRequest, IndicatorDataRequestPk> {
}
