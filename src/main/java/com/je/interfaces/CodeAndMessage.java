package com.je.interfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum CodeAndMessage {

    // common;
    ok("home-10000", "ok"),
    error("home-10010", "error"),
    apiNotExist("home-10030", "api not exist"),
    argIllegal("home-10040", "arg illegal"),

    // admin;
    pwdError("home-11000", "password error"),
    userNameError("home-11001", "userName error"),
    noTokenFound("home-11002", "no token found"),
    ;

    private final String code;

    private final String message;

}
