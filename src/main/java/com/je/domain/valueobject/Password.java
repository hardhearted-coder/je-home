package com.je.domain.valueobject;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Locale;

@ToString
@EqualsAndHashCode
public class Password {

    private final String value;

    public Password(String value) {
        if (StrUtil.isEmpty(value) || value.length() < 8) {
            throw new BizException(CodeAndMessage.argIllegal, "length of password must gt 8");
        }
        this.value = encode(value);
    }

    private String encode(String value) {
        MD5 md5 = MD5.create();
        return md5.digestHex(new String(md5.digest(value))).toUpperCase(Locale.ROOT);
    }

}
