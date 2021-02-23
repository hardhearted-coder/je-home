package com.je.interfaces.controller;

import com.je.application.ro.Health;
import com.je.interfaces.Result;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.IO)
@Controller("/health")
public class HealthController {

    @Value("${welcome}")
    private String welcome;

    @Get("/check")
    public Result<Health> check() {
        return Result.ok(new Health(welcome));
    }

}
