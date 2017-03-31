package com.example.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@RestControllerAdvice
@Slf4j
public class SpringExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Object> springErrorHandler(HttpServletRequest request, BaseException e) {
        Response.StatusType status = Response.Status.fromStatusCode(e.getStatusCode());
        ErrorPayload errorPayload = new ErrorPayload(
                status.getStatusCode(),
                status.getReasonPhrase(),
                new String[]{e.getMessage()},
                request.getRequestURI());

        return ResponseEntity.status(status.getStatusCode()).body(errorPayload);
    }

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Object> springErrorHandler(HttpServletRequest request, Exception e) {
        log.error("Unexpected error: " + e.getMessage(), e);

        Response.StatusType status = Response.Status.INTERNAL_SERVER_ERROR;
        ErrorPayload errorPayload = new ErrorPayload(
                status.getStatusCode(),
                status.getReasonPhrase(),
                new String[]{e.getMessage()},
                request.getRequestURI());

        return ResponseEntity.status(status.getStatusCode()).body(errorPayload);
    }
}
