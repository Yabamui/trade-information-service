package com.service.openapi.trade.wtoapiservice.entities.information;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "STATISTICS", schema = "information_schema")
@Getter
public class DatabaseSchemaStatistics implements Serializable {
    @Column(name = "TABLE_CATALOG")
    private String tableCatalog;
    @Column(name = "TABLE_SCHEMA")
    private String tableSchema;
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Column(name = "NON_UNIQUE")
    private Long nonUnique;
    @Column(name = "INDEX_SCHEMA")
    private String indexSchema;
    @Id
    @Column(name = "INDEX_NAME")
    private String indexName;
    @Column(name = "SEQ_IN_INDEX")
    private Long seqInIndex;
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Column(name = "COLLATION")
    private String collation;
    @Column(name = "CARDINALITY")
    private Long cardinality;
    @Column(name = "SUB_PART")
    private Long subPart;
    @Column(name = "PACKED")
    private String packed;
    @Column(name = "NULLABLE")
    private String nullable;
    @Column(name = "INDEX_TYPE")
    private String indexType;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "INDEX_COMMENT")
    private String indexComment;
}
