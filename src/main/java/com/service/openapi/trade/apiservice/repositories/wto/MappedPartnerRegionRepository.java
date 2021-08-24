package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.MappedPartnerRegion;
import com.service.openapi.trade.apiservice.entities.wto.pk.MappedPartnerRegionPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedPartnerRegionRepository extends JpaRepository<MappedPartnerRegion, MappedPartnerRegionPk> {
}
