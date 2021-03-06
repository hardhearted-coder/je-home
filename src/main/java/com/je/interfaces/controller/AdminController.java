package com.je.interfaces.controller;

import cn.hutool.core.util.StrUtil;
import com.je.application.ro.ResetPasswordRo;
import com.je.application.service.AdminService;
import com.je.application.service.LoginResult;
import com.je.domain.repository.TokenRepo;
import com.je.domain.Token;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import com.je.interfaces.Result;
import com.je.application.ro.LoginRo;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ExecuteOn(TaskExecutors.IO)
@Controller("/admin")
public class AdminController {

    @Inject
    private AdminService adminService;

    /**
     * todo add aspect to find token.
     */
    @Inject
    private TokenRepo tokenRepo;

    @Post("/login")
    public Result<LoginResult> login(@Body LoginRo ro) {
        return Result.ok(adminService.login(ro));
    }

    /**
     * todo `@Transactional`
     */
    @Transactional
    @Post("/reset-pwd")
    public Result<Void> resetPwd(HttpRequest request, @Body ResetPasswordRo ro) {
        String xToken = request.getHeaders().get("X-Token");
        if (StrUtil.isBlank(xToken)) {
            throw new BizException(CodeAndMessage.noTokenFound);
        }
        Optional<Token> optionalToken = tokenRepo.find(xToken);
        if (optionalToken.isEmpty()) {
            throw new BizException(CodeAndMessage.noTokenFound);
        }
        adminService.resetPassword(optionalToken.get(), ro);
        return Result.ok();
    }

}
