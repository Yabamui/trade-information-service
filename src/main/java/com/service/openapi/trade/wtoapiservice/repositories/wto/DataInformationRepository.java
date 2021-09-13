package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.DataInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataInformationRepository extends JpaRepository<DataInformation, Long> {
}
