package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.MappedPartnerRegion;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.MappedPartnerRegionPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedPartnerRegionRepository extends JpaRepository<MappedPartnerRegion, MappedPartnerRegionPk> {
}
