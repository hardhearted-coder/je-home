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

    private final Long userId;

    private final String value;

    public Token(User user) {
        userId = user.getId();
        value = IdUtil.fastSimpleUUID().toUpperCase();
    }

}
