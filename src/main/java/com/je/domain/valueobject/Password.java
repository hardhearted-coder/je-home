package com.je.domain.valueobject;

import cn.hutool.crypto.digest.MD5;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Locale;

@ToString
@EqualsAndHashCode
public class Password {

    private final String value;

    public Password(String value) {
        this.value = encode(value);
    }

    private String encode(String value) {
        MD5 md5 = MD5.create();
        return md5.digestHex(new String(md5.digest(value))).toUpperCase(Locale.ROOT);
    }

}
