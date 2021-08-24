package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.Periods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodsRepository extends JpaRepository<Periods, String> {
}
