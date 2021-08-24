package com.service.openapi.trade.apiservice.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.service.openapi.trade.apiservice.models.enums.DateFormatType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class AgeUtil {
    public static int getRealAge(final String birthday, final String atDate) {
        if (StringUtils.isAnyEmpty(birthday, atDate)) {
            return 0;
        }


        try {
            return (int) LocalDate.parse(birthday, DateFormatType.YYYY_MM_DD.getFormatter())
                    .until(LocalDate.parse(atDate, DateFormatType.YYYY_MM_DD.getFormatter()), ChronoUnit.YEARS);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getRealAge(final String birthday) {
        if (StringUtils.isEmpty(birthday)) {
            return 0;
        }


        try {
            return (int) LocalDate.parse(birthday, DateFormatType.YYYY_MM_DD.getFormatter())
                    .until(LocalDate.now(), ChronoUnit.YEARS);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getInsuranceBirthday(final String birthday) {
        if (StringUtils.isEmpty(birthday)) {
            return null;
        }

        return LocalDate.parse(birthday, DateFormatType.YYYY_MM_DD.getFormatter())
                .minusMonths(6).format(DateFormatType.YYYY_MM_DD.getFormatter());
    }
}
