package com.je.application.service;

import com.je.domain.User;
import com.je.domain.Token;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class LoginResult {

    private final User user;

    private final Token token;

    public LoginResult(User user, Token token) {
        this.user = user;
        this.token = token;
    }

}
