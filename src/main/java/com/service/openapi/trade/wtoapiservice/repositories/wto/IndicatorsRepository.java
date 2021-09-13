package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.Indicators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorsRepository extends JpaRepository<Indicators, String> {
}
