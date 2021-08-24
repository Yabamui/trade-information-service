package com.service.openapi.trade.apiservice.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import feign.Response;
import feign.Util;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class FeignUtil {
    public static String getBodyString(final Response response) {
        try {
            return Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static <T> T getBodyObject(final Response response, final TypeReference<T> reference) {
        if (response.status() != HttpStatus.OK.value()) {
            log.info("response status : " + response.status());
            return null;
        }

        if (Objects.isNull(response.body())) {
            log.info("response body : is empty");
            return null;
        }

        final String responseBody = FeignUtil.getBodyString(response);

        if (!StringUtils.hasText(responseBody)) {
            log.info("response convert fail");
            return null;
        }

        return JsonConvert.toObject(responseBody, reference);
    }
}
