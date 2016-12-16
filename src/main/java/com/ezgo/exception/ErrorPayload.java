package com.ezgo.exception;

/**
 * Created by Raiz on 14/10/2016.
 * Default error response
 */
public class ErrorPayload {

    public final int code;
    public final String message;
    public final long timestamp;
    public final String[] errors;
    public final String path;

    public ErrorPayload(int code, String message, String[] errors, String path) {
        this.code = code;
        this.message = message;
        this.path = path;
        this.timestamp = System.currentTimeMillis();
        this.errors = errors;
    }
}
