package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.ProductClassification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductClassificationRepository extends JpaRepository<ProductClassification, String> {
}
