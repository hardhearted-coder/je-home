package com.je.application.ro;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@EqualsAndHashCode
public final class Health {

    private final String message;

    private final Instant serverTime;

    public Health(String message) {
        this(message, Instant.now());
    }

    public Health(String message, Instant serverTime) {
        this.message = message;
        this.serverTime = serverTime;
    }

}
