package com.service.openapi.trade.wtoapiservice.repositories.information;

import java.util.List;

import com.service.openapi.trade.wtoapiservice.entities.information.DatabaseSchemaStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseSchemaStatisticsRepository extends JpaRepository<DatabaseSchemaStatistics, String> {
    List<DatabaseSchemaStatistics> findAllByTableSchemaAndTableName(String tableSchema, String tableName);
}
