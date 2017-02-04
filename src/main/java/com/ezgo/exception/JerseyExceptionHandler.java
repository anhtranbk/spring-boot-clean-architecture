package com.ezgo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component
@Slf4j
public class JerseyExceptionHandler implements ExceptionMapper<Throwable> {

    @Context
    public UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable e) {
        log.error("Unexpected error: " + e.getMessage(), e);

        Response.StatusType status;
        if (e instanceof WebApplicationException) {
            WebApplicationException we = (WebApplicationException) e;
            status = we.getResponse().getStatusInfo();
        } else {
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }

        ErrorPayload errorPayload = new ErrorPayload(
                status.getStatusCode(),
                status.getReasonPhrase(),
                new String[]{e.getMessage()},
                uriInfo.getRequestUri().toString());

        return Response.status(status.getStatusCode())
                .entity(errorPayload)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
