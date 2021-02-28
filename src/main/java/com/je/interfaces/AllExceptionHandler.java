package com.je.interfaces;

import cn.hutool.core.exceptions.ExceptionUtil;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Optional;

@Slf4j
@Produces
@Singleton
@Requires(classes = {Exception.class, ExceptionHandler.class})
public class AllExceptionHandler implements ExceptionHandler<Exception, HttpResponse<Result<Void>>> {

    private static final String NOT_GOT_ERROR_MESSAGE = "can not got error message";

    @Override
    public HttpResponse<Result<Void>> handle(HttpRequest request, Exception exception) {
        Result<Void> result;
        if (exception instanceof BizException) {
            result = Result.fromBizException((BizException) exception);
        } else {
            result = Result.error(CodeAndMessage.error, Optional.ofNullable(ExceptionUtil.getRootCauseMessage(exception)).orElse(NOT_GOT_ERROR_MESSAGE));
        }
        if (HttpMethod.OPTIONS != request.getMethod()) {
            log.error("<Request> RemoteAddress: {}, Method: {}, Path: {}, Duration: {}",
                    HttpContextUtils.getIp(request), request.getMethod(), request.getPath(), HttpContextUtils.getDuration(request));
        }
        return HttpResponse.serverError().body(result);
    }

}