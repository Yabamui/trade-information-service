package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.EconomicGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicGroupsRepository extends JpaRepository<EconomicGroups, String> {
}
