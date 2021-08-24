package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.MappedReporterGroup;
import com.service.openapi.trade.apiservice.entities.wto.pk.MappedReporterGroupPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedReporterGroupRepository extends JpaRepository<MappedReporterGroup, MappedReporterGroupPk> {
}
