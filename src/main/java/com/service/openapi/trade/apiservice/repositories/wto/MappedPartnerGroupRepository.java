package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.MappedPartnerGroup;
import com.service.openapi.trade.apiservice.entities.wto.pk.MappedPartnerGroupPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedPartnerGroupRepository extends JpaRepository<MappedPartnerGroup, MappedPartnerGroupPk> {
}
