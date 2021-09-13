package com.service.openapi.trade.wtoapiservice.repositories.wto;

import com.service.openapi.trade.wtoapiservice.entities.wto.IndicatorCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorCategoriesRepository extends JpaRepository<IndicatorCategories, String> {
}
