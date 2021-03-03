package com.je.domain;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.je.domain.valueobject.Password;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class User {

    private final Long id;

    private String name;

    @JsonIgnore
    private Password password;

    private final Instant registeredTime;

    public User(String name, Password password) {
        this.name = name;
        this.password = password;
        this.id = IdUtil.getSnowflake(0, 0).nextId();
        this.registeredTime = Instant.now();
    }

    public boolean canLogin(Password password) {
        return this.password.equals(password);
    }

    public void resetPassword(Password password) {
        this.password = password;
    }

}
