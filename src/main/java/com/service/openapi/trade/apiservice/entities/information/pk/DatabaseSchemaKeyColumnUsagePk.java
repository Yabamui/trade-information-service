package com.service.openapi.trade.apiservice.entities.information.pk;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class DatabaseSchemaKeyColumnUsagePk implements Serializable {
    private String constraintName;
    private String tableName;
}
