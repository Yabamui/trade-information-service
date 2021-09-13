package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.MappedReporterRegion;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.MappedReporterRegionPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedReporterRegionRepository extends JpaRepository<MappedReporterRegion, MappedReporterRegionPk> {
}
