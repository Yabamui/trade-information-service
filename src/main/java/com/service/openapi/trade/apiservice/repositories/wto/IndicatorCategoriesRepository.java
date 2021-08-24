package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.IndicatorCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorCategoriesRepository extends JpaRepository<IndicatorCategories, String> {
}
