package com.je.interfaces;

import com.je.infrastructure.helper.TimeHelper;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpContextUtils {

    private static final String BEGIN_TIME = "beginTime";

    public static void beginTiming(HttpRequest request) {
        request.setAttribute(BEGIN_TIME, LocalDateTime.now());
    }

    public static String getDuration(HttpRequest request) {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime beginTime = (LocalDateTime) request.getAttribute(BEGIN_TIME).orElse(endTime);
        return TimeHelper.prettyBetween(beginTime, endTime);
    }

    public static String getIp(HttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        Optional<String> xffOptional = headers.get("X-Forwarded-For", String.class);
        if (xffOptional.isPresent()) {
            String xffHeader = xffOptional.get();
            return xffHeader.contains(",") ? xffHeader.substring(0, xffHeader.indexOf(",")) : xffHeader;
        }
        return request.getRemoteAddress().getHostName();
    }

    public static String getUserAgent(HttpRequest request) {
        return request.getHeaders().get(HttpHeaders.USER_AGENT);
    }

}
