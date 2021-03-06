package com.je.domain;

import cn.hutool.core.util.IdUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Table
@Entity
@Getter
@ToString
@EqualsAndHashCode
public class Token {

    @Id
    private String id;

    private long uid;

    private Instant expire;

    public Token(long uid) {
        id = IdUtil.fastSimpleUUID().toUpperCase();
        this.uid = uid;
        expire = Instant.now().plus(1, ChronoUnit.HOURS);
    }


    /**
     * this constructor can only be called by po.
     */
    public Token() {
    }

}
