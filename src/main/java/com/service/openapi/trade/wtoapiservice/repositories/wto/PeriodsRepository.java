package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.Periods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodsRepository extends JpaRepository<Periods, String> {
}
