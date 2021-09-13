package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.ProductClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductClassificationRepository extends JpaRepository<ProductClassification, String> {
}
