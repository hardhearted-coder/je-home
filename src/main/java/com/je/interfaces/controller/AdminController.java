package com.je.interfaces.controller;

import com.je.application.ro.ResetPasswordRo;
import com.je.application.service.AdminService;
import com.je.domain.valueobject.Token;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import com.je.interfaces.HttpContextUtils;
import com.je.interfaces.Result;
import com.je.application.ro.LoginRo;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller("/admin")
public class AdminController {

    @Inject
    private AdminService adminService;

    @Post("/login")
    public Result<Token> login(@Body LoginRo ro) {
        return Result.ok(adminService.login(ro));
    }

    @Post("/reset-pwd")
    public Result<Void> resetPwd(HttpRequest request, @Body ResetPasswordRo ro) {
        Optional<Token> optionalToken = HttpContextUtils.getToken(request);
        if (optionalToken.isPresent()) {
            adminService.resetPassword(optionalToken.get(), ro);
            return Result.ok();
        }
        throw new BizException(CodeAndMessage.noTokenFound);
    }

}
