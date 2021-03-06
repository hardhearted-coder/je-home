package com.je.application.service;

import cn.hutool.core.util.StrUtil;
import com.je.application.ro.LoginRo;
import com.je.application.ro.ResetPasswordRo;
import com.je.domain.User;
import com.je.domain.repository.TokenRepo;
import com.je.domain.repository.UserRepo;
import com.je.domain.svc.LoginSvc;
import com.je.domain.valueobject.Password;
import com.je.domain.Token;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @Transactional must on class, otherwise:
 * Could not obtain transaction-synchronized Session for current thread.
 */
@Transactional
@Singleton
public class AdminService {

    @Inject
    private LoginSvc loginSvc;

    @Inject
    private UserRepo userRepo;

    @Inject
    private TokenRepo tokenRepo;

    public LoginResult login(LoginRo ro) {
        if (StrUtil.isEmpty(ro.getName()) || StrUtil.isEmpty(ro.getPassword())) {
            throw new BizException(CodeAndMessage.argIllegal, "name and password can not be empty");
        }
        Optional<User> user = userRepo.findByName(ro.getName());
        if (user.isEmpty()) {
            throw new BizException(CodeAndMessage.userNameError);
        }
        Token token = loginSvc.login(user.get(), new Password(ro.getPassword()));
        tokenRepo.findByUid(user.get().getId()).ifPresent(tokenRepo::delete);
        tokenRepo.create(token);
        return new LoginResult(user.get(), token);
    }

    public void resetPassword(Token token, ResetPasswordRo ro) {
        Password originalPwd = new Password(ro.getOriginalPwd());
        Password newPwd = new Password(ro.getNewPwd());

        // find user by token.uid;
        Optional<User> optionalUser = userRepo.find(token.getUid());
        if (optionalUser.isEmpty()) {
            throw new BizException(CodeAndMessage.error, "can not found user by token.uid");
        }
        User user = optionalUser.get();

        // check if original pwd correct;
        if (!user.canLogin(originalPwd)) {
            throw new BizException(CodeAndMessage.pwdError);
        }

        // original pwd correct;
        user.resetPassword(newPwd);
        userRepo.update(user);
        tokenRepo.delete(token);
    }

}
