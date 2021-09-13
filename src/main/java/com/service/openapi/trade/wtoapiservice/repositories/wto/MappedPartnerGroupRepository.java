package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.MappedPartnerGroup;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.MappedPartnerGroupPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappedPartnerGroupRepository extends JpaRepository<MappedPartnerGroup, MappedPartnerGroupPk> {
}
