package com.service.openapi.trade.apiservice.repositories.information;

import java.util.List;

import com.service.openapi.trade.apiservice.entities.information.DatabaseSchemaColumns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseSchemaColumnsRepository extends JpaRepository<DatabaseSchemaColumns, String> {
    List<DatabaseSchemaColumns> findAllByTableSchemaAndTableName(String tableSchema, String tableName);
}
