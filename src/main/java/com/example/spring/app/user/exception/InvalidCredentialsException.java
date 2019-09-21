package com.example.spring.app.user.exception;

import com.example.spring.exception.BaseException;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BaseException {

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCredentialsException(Throwable cause) {
        super(cause);
    }

    @Override
    protected int getStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
