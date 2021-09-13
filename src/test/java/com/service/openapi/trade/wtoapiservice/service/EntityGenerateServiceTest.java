package com.service.openapi.trade.wtoapiservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.service.openapi.trade.wtoapiservice.entities.information.DatabaseSchemaColumns;
import com.service.openapi.trade.wtoapiservice.entities.information.DatabaseSchemaKeyColumnUsage;
import com.service.openapi.trade.wtoapiservice.repositories.information.DatabaseSchemaColumnsRepository;
import com.service.openapi.trade.wtoapiservice.repositories.information.DatabaseSchemaKeyColumnUsageRepository;
import com.service.openapi.trade.wtoapiservice.utils.JsonConvert;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
class EntityGenerateServiceTest {
    @Autowired
    private DatabaseSchemaColumnsRepository dataBaseSchemaColumnsRepository;

    @Autowired
    private DatabaseSchemaKeyColumnUsageRepository databaseSchemaKeyColumnUsageRepository;

    @Builder
    @Getter
    static class EntityData {
        private final List<String> prefixColumnValue;
        private final String columnValue;
        private final String scope;
        private final String dataType;
        private final String name;

        private static final String FINAL_KEYWORD = "final";
        private static final String LINE = "\n";
        private static final String SPACE = " ";
        private static final String FINAL = ";";

        public String toString() {
            StringBuilder builder = new StringBuilder();

            if (!CollectionUtils.isEmpty(this.prefixColumnValue)) {
                prefixColumnValue.forEach(value -> builder.append(value).append(LINE));
            }

            builder.append(this.columnValue).append(LINE).append(scope).append(SPACE)
                    .append(dataType).append(SPACE).append(name).append(FINAL);

            return builder.toString();
        }

        public static String toBuilderString(String tableClassName, List<EntityData> entityDataList) {
            return  "@Builder" + LINE +
                    "private" + SPACE +
                    tableClassName +
                    "(" +
                    entityDataList.stream().filter(f -> !f.getPrefixColumnValue().contains("@Id"))
                            .filter(f -> !f.getPrefixColumnValue().contains("@CreationTimestamp"))
                            .filter(f -> !f.getPrefixColumnValue().contains("@UpdateTimestamp"))
                            .map(data -> FINAL_KEYWORD + SPACE + data.getDataType() + SPACE + data.getName()).collect(Collectors.joining(", ")) +
                    ") {" +
                    LINE +
                    entityDataList.stream().filter(f -> !f.getPrefixColumnValue().contains("@Id"))
                            .filter(f -> !f.getPrefixColumnValue().contains("@CreationTimestamp"))
                            .filter(f -> !f.getPrefixColumnValue().contains("@UpdateTimestamp"))
                            .map(data -> "this." + data.getName() + SPACE + "=" + SPACE + data.getName() + FINAL)
                            .collect(Collectors.joining(LINE)) +
                    LINE +
                    "}";
        }
    }

    @Test
    void getDatabaseSchemaColumns() {
        final String tableSchema = "trade_information";
        final String tableName = "naver_shopping_category";

        final List<DatabaseSchemaColumns> columnsList = dataBaseSchemaColumnsRepository.findAllByTableSchemaAndTableName(tableSchema, tableName);

        assertThat(columnsList).isNotNull().isNotEmpty();

        log.info(JsonConvert.toString(columnsList));

        final List<EntityData> entityDataList = new ArrayList<>();

        for (DatabaseSchemaColumns columns : columnsList) {

            DatabaseSchemaKeyColumnUsage columnUsage = null;

            if (columns.getColumnKey().equals("MUL") || columns.getColumnKey().equals("UNI")) {
                columnUsage = databaseSchemaKeyColumnUsageRepository
                        .findTopByTableSchemaAndTableNameAndColumnNameAndReferencedColumnNameIsNotNull(tableSchema, tableName, columns.getColumnName());
            }

            entityDataList.add(EntityData.builder()
                    .prefixColumnValue(this.getPrefixColumnValue(columns))
                    .columnValue(this.getColumnValueByColumns(columns, columnUsage))
                    .scope("private")
                    .dataType(this.getDateTypeByColumns(columns, columnUsage))
                    .name(this.getColumnNameByColumns(columns, columnUsage))
                    .build());
        }

        log.info("Class name : " + this.convertToTitleCaseIteratingChars(tableName, true));
        log.info("Table name : " + tableName);
        log.info("Class information\n" + entityDataList.stream().map(EntityData::toString)
                .collect(Collectors.joining("\n\n")));
        log.info("class Builder\n" + EntityData.toBuilderString(this.convertToTitleCaseIteratingChars(tableName, true), entityDataList));
    }

    private List<String> getPrefixColumnValue(DatabaseSchemaColumns columns) {
        List<String> prefixColumnValues = new ArrayList<>();

        if (columns.getColumnKey().equals("PRI")) {
            prefixColumnValues.add("@Id");
            prefixColumnValues.add("@GeneratedValue(strategy = GenerationType.IDENTITY)");
        }

        if (columns.getColumnKey().equals("MUL")) {
            prefixColumnValues.add("@ManyToOne(optional = false, fetch = FetchType.LAZY)");
        }

        if (columns.getColumnKey().equals("UNI")) {
            prefixColumnValues.add("@OneToOne(optional = false, fetch = FetchType.LAZY)");
        }

        if (columns.getColumnName().equals("created_at")) {
            prefixColumnValues.add("@CreationTimestamp");
        }

        if (columns.getColumnName().equals("updated_at")) {
            prefixColumnValues.add("@UpdateTimestamp");
        }

        return prefixColumnValues;
    }

    private String getColumnValueByColumns(DatabaseSchemaColumns columns, DatabaseSchemaKeyColumnUsage columnUsage) {
        StringBuilder builder = new StringBuilder();
        if (Objects.nonNull(columnUsage) && (columns.getColumnKey().equals("MUL") || columns.getColumnKey().equals("UNI"))) {
            builder.append("@JoinColumn(name = \"")
                    .append(columns.getColumnName())
                    .append("\", referencedColumnName = \"")
                    .append(columnUsage.getReferencedColumnName())
                    .append("\"");
        } else {
            builder.append("@Column(name = \"")
                    .append(columns.getColumnName()).append("\"");

            if (Objects.nonNull(columns.getCharacterMaximumLength())) {
                builder.append(", length = ").append(columns.getCharacterMaximumLength());
            }
        }

        if (columns.getIsNullable().equals("NO")) {
            builder.append(", nullable = false");
        }

        if (StringUtils.hasText(columns.getColumnComment())) {
            builder.append(", columnDefinition = \"")
                    .append(columns.getColumnType());

            if (columns.getColumnDefault() != null) {
                builder.append(" default ");
                if (columns.getDataType().equals("varchar")) {
                    builder.append("'").append(columns.getColumnDefault()).append("'");
                } else {
                    builder.append(columns.getColumnDefault());
                }
            }

            builder.append(" comment '").append(columns.getColumnComment()).append("'\"");
        }

        return builder.append(")").toString();
    }

    private String getDateTypeByColumns(DatabaseSchemaColumns columns, DatabaseSchemaKeyColumnUsage columnUsage) {
        if (Objects.nonNull(columnUsage) && (columns.getColumnKey().equals("MUL") || columns.getColumnKey().equals("UNI"))) {
            return this.convertToTitleCaseIteratingChars(columnUsage.getReferencedTableName(), true);
        }

        switch (columns.getDataType()) {
            case "bigint":
                return "Long";
            case "tinyint":
                return "Boolean";
            case "datetime":
                return "Timestamp";
            default:
                return "String";
        }
    }

    private String getColumnNameByColumns(DatabaseSchemaColumns columns, DatabaseSchemaKeyColumnUsage columnUsage) {
        if (Objects.nonNull(columnUsage) && (columns.getColumnKey().equals("MUL") || columns.getColumnKey().equals("UNI"))) {
            return this.convertToTitleCaseIteratingChars(columnUsage.getReferencedTableName(), false);
        }

        return this.convertToTitleCaseIteratingChars(columns.getColumnName(), false);
    }

    private String convertToTitleCaseIteratingChars(String text, boolean isStartTitleCase) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        text = text.replaceAll("_", " ");

        StringBuilder converted = new StringBuilder();

        boolean convertNext = isStartTitleCase;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
                continue;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
