package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.ValueFlags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueFlagsRepository extends JpaRepository<ValueFlags, String> {
}
