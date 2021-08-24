package com.service.openapi.trade.apiservice.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StringUtils;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
class JsonToClassServiceTest {
    @Test
    void getClassFileData() {
        assertThat(REQUEST_JSON).isNotBlank();

        final StringBuilder builder = new StringBuilder();

        final JsonObject jsonObject = JsonParser.parseString(REQUEST_JSON).getAsJsonObject();

        final Map<String, JsonObject> objectMap = new HashMap<>();

        objectMap.put("MainClass", jsonObject);

        setObjectMap(jsonObject, objectMap);

        objectMap.forEach((key, value) -> builder.append(getJsonObjectValue(key, value)).append("\n"));

        log.info(builder.toString());
    }

    private static void setObjectMap(final JsonObject jsonObject, final Map<String, JsonObject> objectMap) {
        jsonObject.entrySet().forEach(json1 -> {
            if (json1.getValue().isJsonObject()) {
                objectMap.put(StringUtils.capitalize(json1.getKey()), json1.getValue().getAsJsonObject());
                setObjectMap(json1.getValue().getAsJsonObject(), objectMap);
            } else if(json1.getValue().isJsonArray() && json1.getValue().getAsJsonArray().get(0).isJsonObject()) {
                objectMap.put(StringUtils.capitalize(json1.getKey()), json1.getValue().getAsJsonArray().get(0).getAsJsonObject());
                setObjectMap(json1.getValue().getAsJsonArray().get(0).getAsJsonObject(), objectMap);
            }
        });
    }

    private static String getJsonObjectValue(final String className, final JsonObject jsonObject) {
        final StringBuilder classBuilder = new StringBuilder()
                .append("\n")
                .append("import com.google.gson.annotations.SerializedName;").append("\n")
                .append("import lombok.*;").append("\n").append("\n")
                .append("@Builder").append("\n")
                .append("@Getter").append("\n")
                .append("@AllArgsConstructor(access = AccessLevel.PROTECTED)").append("\n")
                .append("public class ").append(className).append("{\n");

        jsonObject.entrySet().forEach(json -> {
            if (json.getValue().isJsonPrimitive() || json.getValue().isJsonNull()) {
                classBuilder.append(getJsonPrimitiveValue(json.getKey(), json.getValue())).append("\n");
            } else if (json.getValue().isJsonArray()) {
                classBuilder.append(getJsonArrayValue(json.getKey(), json.getValue())).append("\n");
            } else if (json.getValue().isJsonObject()) {
                classBuilder.append("private final ").append(StringUtils.capitalize(json.getKey()))
                        .append(" ").append(json.getKey()).append(";").append("\n");
            }
        });

        return classBuilder.append("}").toString();
    }

    private static String getJsonPrimitiveValue(final String key, final JsonElement jsonElement) {
        final StringBuilder builder = new StringBuilder("@SerializedName(\"").append(key).append("\")\n").append("private final ");

        if (jsonElement.isJsonNull()) {
            builder.append("String ");
        } else if (jsonElement.getAsJsonPrimitive().isBoolean()) {
            builder.append("Boolean ");
        } else if (jsonElement.getAsJsonPrimitive().isNumber()) {
            if (jsonElement.getAsInt() == jsonElement.getAsLong()) {
                builder.append("Integer ");
            } else {
                builder.append("Long ");
            }
        } else {
            builder.append("String ");
        }

        return builder.append(StringUtils.uncapitalize(key)).append(";").toString();
    }

    private static String getJsonArrayValue(final String key, final JsonElement jsonElement) {
        final StringBuilder builder = new StringBuilder("@SerializedName(\"").append(key).append("\")\n").append("private final List");

        if (jsonElement.getAsJsonArray().size() == 0) {
            return builder.append(" ").append(key).append(";").toString();
        }

        if (jsonElement.getAsJsonArray().get(0).isJsonNull() || jsonElement.getAsJsonArray().get(0).isJsonPrimitive()) {
            if (jsonElement.getAsJsonArray().get(0).isJsonNull()) {
                builder.append("<String> ");
            } else if (jsonElement.getAsJsonArray().get(0).getAsJsonPrimitive().isBoolean()) {
                builder.append("<Boolean> ");
            } else if (jsonElement.getAsJsonArray().get(0).getAsJsonPrimitive().isNumber()) {
                if (jsonElement.getAsJsonArray().get(0).getAsInt() == jsonElement.getAsJsonArray().get(0).getAsLong()) {
                    builder.append("<Integer> ");
                } else {
                    builder.append("<Long> ");
                }
            } else {
                builder.append("<String> ");
            }
        } else {
            builder.append("<").append(StringUtils.capitalize(key)).append("> ");
        }

        return builder.append(StringUtils.uncapitalize(key)).append(";").toString();
    }

    private final static String REQUEST_JSON = "{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2010,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0}";
}
