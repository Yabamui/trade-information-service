package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.Units;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitsRepository extends JpaRepository<Units, String> {
}
