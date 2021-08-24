package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.TerritoryRegions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRegionsRepository extends JpaRepository<TerritoryRegions, String> {
}
