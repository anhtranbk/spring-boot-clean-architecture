package com.example.spring.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {

    @Override
    protected int getStatusCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
