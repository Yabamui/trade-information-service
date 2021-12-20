package com.service.openapi.trade.wtoapiservice.entities.information;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "TABLES", schema = "information_schema")
@Getter
public class DatabaseSchemaTable implements Serializable {
    @Column(name = "TABLE_CATALOG")
    private String tableCatalog;
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;
    @Id
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Column(name = "TABLE_TYPE")
    private String tableType;
    @Column(name = "ENGINE")
    private String engine;
    @Column(name = "VERSION")
    private String version;
    @Column(name = "ROW_FORMAT")
    private String rowFormat;
    @Column(name = "TABLE_ROWS")
    private String tableRows;
    @Column(name = "AVG_ROW_LENGTH")
    private String avgRowLength;
    @Column(name = "DATA_LENGTH")
    private String dataLength;
    @Column(name = "MAX_DATA_LENGTH")
    private String maxDataLength;
    @Column(name = "INDEX_LENGTH")
    private String indexLength;
    @Column(name = "DATA_FREE")
    private String dataFree;
    @Column(name = "AUTO_INCREMENT")
    private String autoIncrement;
    @Column(name = "CREATE_TIME")
    private String createTime;
    @Column(name = "UPDATE_TIME")
    private String updateTime;
    @Column(name = "CHECK_TIME")
    private String checkTime;
    @Column(name = "TABLE_COLLATION")
    private String tableCollation;
    @Column(name = "CHECKSUM")
    private String checksum;
    @Column(name = "CREATE_OPTIONS")
    private String createOptions;
    @Column(name = "TABLE_COMMENT")
    private String tableComment;
}
