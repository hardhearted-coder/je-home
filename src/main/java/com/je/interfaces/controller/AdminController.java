package com.je.interfaces.controller;

import com.je.application.service.LoginService;
import com.je.domain.valueobject.Token;
import com.je.interfaces.Result;
import com.je.application.ro.LoginRo;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;

@ExecuteOn(TaskExecutors.IO)
@Controller("/admin")
public class AdminController {

    @Inject
    private LoginService loginService;

    @Post("/login")
    public Result<Token> login(@Body LoginRo ro) {
        return Result.ok(loginService.login(ro));
    }

}
