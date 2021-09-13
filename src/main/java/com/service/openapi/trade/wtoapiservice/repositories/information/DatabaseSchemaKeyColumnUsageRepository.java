package com.service.openapi.trade.wtoapiservice.repositories.information;

import com.service.openapi.trade.wtoapiservice.entities.information.DatabaseSchemaKeyColumnUsage;
import com.service.openapi.trade.wtoapiservice.entities.information.pk.DatabaseSchemaKeyColumnUsagePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseSchemaKeyColumnUsageRepository extends JpaRepository<DatabaseSchemaKeyColumnUsage, DatabaseSchemaKeyColumnUsagePk> {
    DatabaseSchemaKeyColumnUsage findTopByTableSchemaAndTableNameAndColumnNameAndReferencedColumnNameIsNotNull(
            String tableSchema, String tableName, String columnName);
}

