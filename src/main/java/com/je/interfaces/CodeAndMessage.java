package com.je.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum CodeAndMessage {

    ok("home-10000", "ok"),
    error("home-10010", "error"),
    apiNotExist("home-10030", "api not exist"),
    paramIllegal("home-10040", "param illegal"),

    // login;
    pwdError("home-11000", "password error"),

    ;

    private final String code;

    private final String message;

}
