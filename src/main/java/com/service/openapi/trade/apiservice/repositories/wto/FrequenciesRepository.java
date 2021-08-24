package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.Frequencies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequenciesRepository extends JpaRepository<Frequencies, String> {
}
