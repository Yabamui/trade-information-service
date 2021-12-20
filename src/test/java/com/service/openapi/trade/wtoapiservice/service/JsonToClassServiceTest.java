package com.service.openapi.trade.wtoapiservice.service;

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
                .append("import com.fasterxml.jackson.annotation.JsonProperty;").append("\n")
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
        final StringBuilder builder = new StringBuilder("@JsonProperty(\"").append(key).append("\")\n").append("private final ");

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
        final StringBuilder builder = new StringBuilder("@JsonProperty(\"").append(key).append("\")\n").append("private final List");

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

    private final static String REQUEST_JSON = "{\n" +
            "    \"ogCd\": \"B1AAAR0000\",\n" +
            "    \"pdtNm\": \"스마트저축1.4(無)_적립_5년만기이상\",\n" +
            "    \"isKdDvCd\": \"01\",\n" +
            "    \"cnrSsCd\": \"02\",\n" +
            "    \"rnwYn\": false,\n" +
            "    \"cnrDt\": \"201509\",\n" +
            "    \"expDt\": \"99991231\",\n" +
            "    \"sbcAmt\": 10000000,\n" +
            "    \"sbcAmtCucyCd\": \"KRW\",\n" +
            "    \"vbIsYn\": false,\n" +
            "    \"uvsIsYn\": false,\n" +
            "    \"anBgnDt\": \"\",\n" +
            "    \"anRecpCyc\": \"\",\n" +
            "    \"lnExecPsPdtYn\": false,\n" +
            "    \"prgNrt\": 0.0,\n" +
            "    \"rdCtnRflnYn\": true,\n" +
            "    \"svcTgtCmyCd\": \"BOMAPP\",\n" +
            "    \"paPdDvCd\": \"02\",\n" +
            "    \"paCycCd\": \"1M\",\n" +
            "    \"ttPaUcn\": 240,\n" +
            "    \"paEdDt\": \"20410705\",\n" +
            "    \"paPrm\": 200000,\n" +
            "    \"paPrmCucyCd\": \"KRW\",\n" +
            "    \"isrCnt\": 1,\n" +
            "    \"isrList\": [\n" +
            "        {\n" +
            "            \"isrSeq\": \"01\",\n" +
            "            \"mnsrYn\": true,\n" +
            "            \"cnrDtBsIsAe\": 37,\n" +
            "            \"aeScList\": [\n" +
            "                {\n" +
            "                    \"cuBsIsAe\": 43,\n" +
            "                    \"cuBsDt\": \"20210705\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"cuBsIsAe\": 60,\n" +
            "                    \"cuBsDt\": \"20370903\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"cuBsIsAe\": 110,\n" +
            "                    \"cuBsDt\": \"20870903\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"scnList\": [\n" +
            "                {\n" +
            "                    \"scnSeq\": 1,\n" +
            "                    \"scnNm\": \"스마트저축1.4(無)_적립\",\n" +
            "                    \"scnSsCd\": \"02\",\n" +
            "                    \"scnExpDt\": \"99991231\",\n" +
            "                    \"scnSbcAmt\": 12000000,\n" +
            "                    \"scnSbcAmtCucyCd\": \"KRW\",\n" +
            "                    \"scnEssnYn\": true\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
