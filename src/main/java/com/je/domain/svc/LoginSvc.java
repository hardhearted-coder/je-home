package com.je.domain.svc;

import com.je.domain.User;
import com.je.domain.valueobject.Password;
import com.je.domain.Token;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;

import javax.inject.Singleton;

@Singleton
public class LoginSvc {

    public Token login(User user, Password password) {
        if (!user.canLogin(password)) {
            throw new BizException(CodeAndMessage.pwdError);
        }
        return new Token(user.getId());
    }

}
