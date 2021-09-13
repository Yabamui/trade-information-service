package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.EconomicReporters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicReportersRepository extends JpaRepository<EconomicReporters, String> {
}
