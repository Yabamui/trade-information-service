package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.MappedReporterGroup;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.MappedReporterGroupPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedReporterGroupRepository extends JpaRepository<MappedReporterGroup, MappedReporterGroupPk> {
}
