package com.service.openapi.trade.apiservice.entities.information;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "COLUMNS", schema = "information_schema")
@Getter
public class DatabaseSchemaColumns implements Serializable {
    @Column(name = "TABLE_CATALOG")
    private String tableCatalog;
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Id
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name = "ORDINAL_POSITION")
    private Long ordinalPosition;
    @Column(name = "COLUMN_DEFAULT")
    private String columnDefault;
    @Column(name = "IS_NULLABLE")
    private String isNullable;
    @Column(name = "DATA_TYPE")
    private String dataType;
    @Column(name = "CHARACTER_MAXIMUM_LENGTH")
    private Long characterMaximumLength;
    @Column(name = "CHARACTER_OCTET_LENGTH")
    private Long characterOctetLength;
    @Column(name = "NUMERIC_PRECISION")
    private Long numericPrecision;
    @Column(name = "NUMERIC_SCALE")
    private Long numericScale;
    @Column(name = "DATETIME_PRECISION")
    private Long datetimePrecision;
    @Column(name = "CHARACTER_SET_NAME")
    private String characterSetName;
    @Column(name = "COLLATION_NAME")
    private String collationName;
    @Column(name = "COLUMN_TYPE")
    private String columnType;
    @Column(name = "COLUMN_KEY")
    private String columnKey;
    @Column(name = "EXTRA")
    private String extra;
    @Column(name = "PRIVILEGES")
    private String privileges;
    @Column(name = "COLUMN_COMMENT")
    private String columnComment;
    @Column(name = "GENERATION_EXPRESSION")
    private String generationExpression;
}
