package com.je.application.service;

import cn.hutool.core.util.StrUtil;
import com.je.application.ro.LoginRo;
import com.je.domain.repository.UserRepo;
import com.je.domain.svc.LoginSvc;
import com.je.domain.valueobject.Password;
import com.je.domain.valueobject.Token;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginService {

    @Inject
    private LoginSvc loginSvc;

    @Inject
    private UserRepo userRepo;

    public Token login(LoginRo ro) {
        if (StrUtil.isEmpty(ro.getName()) || StrUtil.isEmpty(ro.getPassword())) {
            throw new BizException(CodeAndMessage.paramIllegal, "name and password can not be empty");
        }
        return userRepo.find(ro.getName())
                .map(user -> loginSvc.login(user, new Password(ro.getPassword())))
                .orElseThrow(() -> new BizException(CodeAndMessage.userNameError));
    }

}
