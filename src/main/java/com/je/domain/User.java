package com.je.domain;

import cn.hutool.core.util.IdUtil;
import com.je.domain.valueobject.Password;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class User {

    private Long id;

    private String name;

    private Password password;

    private Instant registeredTime;

    public User(String name, Password password) {
        this.name = name;
        this.password = password;
        this.id = IdUtil.getSnowflake(0, 0).nextId();
        this.registeredTime = Instant.now();
    }

    public boolean canLogin(Password password) {
        return this.password.equals(password);
    }

}