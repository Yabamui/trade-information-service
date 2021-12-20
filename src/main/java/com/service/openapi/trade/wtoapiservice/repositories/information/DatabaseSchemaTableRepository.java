package com.service.openapi.trade.wtoapiservice.repositories.information;

import java.util.List;

import com.service.openapi.trade.wtoapiservice.entities.information.DatabaseSchemaTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseSchemaTableRepository extends JpaRepository<DatabaseSchemaTable, String> {
    DatabaseSchemaTable findByTableSchemaAndTableName(final String tableSchema, final String tableName);
    List<DatabaseSchemaTable> findAllByTableSchemaAndTableNameLike(final String tableSchema, final String tableNameRegex);
}
