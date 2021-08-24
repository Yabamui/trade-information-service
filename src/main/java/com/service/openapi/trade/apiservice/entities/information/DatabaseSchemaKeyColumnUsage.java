package com.service.openapi.trade.apiservice.entities.information;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.information.pk.DatabaseSchemaKeyColumnUsagePk;
import lombok.Getter;

@Entity
@Table(name = "KEY_COLUMN_USAGE", schema = "information_schema")
@IdClass(DatabaseSchemaKeyColumnUsagePk.class)
@Getter
public class DatabaseSchemaKeyColumnUsage implements Serializable {
    @Column(name = "CONSTRAINT_CATALOG")
    private String constraintCatalog;
    @Column(name = "CONSTRAINT_SCHEMA")
    private String constraintSchema;
    @Id
    @Column(name = "CONSTRAINT_NAME")
    private String constraintName;
    @Column(name = "TABLE_CATALOG")
    private String tableCatalog;
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;
    @Id
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name = "ORDINAL_POSITION")
    private Long ordinalPosition;
    @Column(name = "POSITION_IN_UNIQUE_CONSTRAINT")
    private Long positionInUniqueConstraint;
    @Column(name = "REFERENCED_TABLE_SCHEMA")
    private String referencedTableSchema;
    @Column(name = "REFERENCED_TABLE_NAME")
    private String referencedTableName;
    @Column(name = "REFERENCED_COLUMN_NAME")
    private String referencedColumnName;
}
