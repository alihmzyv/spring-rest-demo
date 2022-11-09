package com.example.springrestdemo.exception;

import java.time.Instant;

public class DefaultExceptionResponse {
    private final int status;
    private final String message;
    private final long timeStamp = Instant.now().toEpochMilli();

    public DefaultExceptionResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}