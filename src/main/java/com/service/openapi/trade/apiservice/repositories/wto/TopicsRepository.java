package com.service.openapi.trade.apiservice.repositories.wto;

import com.service.openapi.trade.apiservice.entities.wto.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topics, Integer> {
}
