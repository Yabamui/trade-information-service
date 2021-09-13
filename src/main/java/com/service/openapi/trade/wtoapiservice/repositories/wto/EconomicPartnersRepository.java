package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.EconomicPartners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicPartnersRepository extends JpaRepository<EconomicPartners, String> {
}
