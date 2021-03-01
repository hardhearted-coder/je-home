package com.je.domain.valueobject;

import cn.hutool.core.util.IdUtil;
import com.je.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Token {

    private final User user;

    private final Value token;

    public Token(User user) {
        this.user = user;
        token = new Value(IdUtil.fastSimpleUUID().toUpperCase());
    }

    @Getter
    @ToString
    @EqualsAndHashCode
    public static class Value {

        private final String value;

        public Value(String value) {
            this.value = value;
        }

    }

}
