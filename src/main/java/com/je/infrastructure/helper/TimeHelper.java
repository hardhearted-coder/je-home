package com.je.infrastructure.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeHelper {

    public static String prettyBetween(Instant begin, Instant end) {
        String negative = "";
        if (begin.isAfter(end)) {
            negative = "-";
            Instant temp = begin;
            begin = end;
            end = temp;
        }
        long minutes = ChronoUnit.MINUTES.between(begin, end);
        if (minutes < 2) {
            long seconds = ChronoUnit.SECONDS.between(begin, end);
            if (seconds < 10) {
                long millis = ChronoUnit.MILLIS.between(begin, end);
                if (millis < 2) {
                    long micros = ChronoUnit.MICROS.between(begin, end);
                    if (micros < 2) {
                        return negative + ChronoUnit.NANOS.between(begin, end) + "ns";
                    }
                    return negative + micros + "μs";
                }
                return negative + millis + "ms";
            }
            return negative + seconds + "s";
        }
        return negative + minutes + "min";
    }

    public static String prettyBetween(LocalDateTime begin, LocalDateTime end) {
        return prettyBetween(begin.toInstant(ZoneOffset.UTC), end.toInstant(ZoneOffset.UTC));
    }

}
