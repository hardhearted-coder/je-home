package com.je.domain;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.je.interfaces.BizException;
import com.je.interfaces.CodeAndMessage;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
public class Blog {

    private Long id;

    private String title;

    private String content;

    private Instant createdTime;

    public Blog(String title, String content) {
        if (StrUtil.isBlank(title)) {
            throw new BizException(CodeAndMessage.argIllegal, "title is blank");
        }
        if (StrUtil.isBlank(content)) {
            throw new BizException(CodeAndMessage.argIllegal, "content is blank");
        }
        this.title = title;
        this.content = content;
        this.id = IdUtil.getSnowflake(0, 0).nextId();
        this.createdTime = Instant.now();
    }

}
