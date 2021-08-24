package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.MappedReporterRegion;
import com.service.openapi.trade.apiservice.entities.wto.pk.MappedReporterRegionPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedReporterRegionRepository extends JpaRepository<MappedReporterRegion, MappedReporterRegionPk> {
}
