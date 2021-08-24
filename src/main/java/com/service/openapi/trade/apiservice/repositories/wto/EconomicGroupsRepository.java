package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.EconomicGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicGroupsRepository extends JpaRepository<EconomicGroups, String> {
}
