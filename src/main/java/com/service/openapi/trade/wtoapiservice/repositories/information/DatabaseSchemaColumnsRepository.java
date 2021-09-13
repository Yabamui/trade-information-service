package com.service.openapi.trade.wtoapiservice.repositories.information;

import java.util.List;

import com.service.openapi.trade.wtoapiservice.entities.information.DatabaseSchemaColumns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseSchemaColumnsRepository extends JpaRepository<DatabaseSchemaColumns, String> {
    List<DatabaseSchemaColumns> findAllByTableSchemaAndTableName(String tableSchema, String tableName);
}
