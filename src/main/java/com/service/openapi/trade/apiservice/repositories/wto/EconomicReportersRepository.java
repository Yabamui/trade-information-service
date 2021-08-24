package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.EconomicReporters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicReportersRepository extends JpaRepository<EconomicReporters, String> {
}
