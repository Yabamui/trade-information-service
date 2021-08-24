package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.EconomicPartners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicPartnersRepository extends JpaRepository<EconomicPartners, String> {
}
