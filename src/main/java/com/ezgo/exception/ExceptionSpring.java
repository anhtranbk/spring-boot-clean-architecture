package com.ezgo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

@ControllerAdvice
public class ExceptionSpring {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionSpring.class);

    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<Object> springErrorHandler(HttpServletRequest request, Exception e) {
        logger.error(e.getMessage(), e);

        Response.StatusType status = Response.Status.INTERNAL_SERVER_ERROR;
        ErrorPayload errorPayload = new ErrorPayload(
                status.getStatusCode(),
                status.getReasonPhrase(),
                new String[]{e.getMessage()},
                request.getRequestURI());

        return ResponseEntity.status(status.getStatusCode()).body(errorPayload);
    }
}
