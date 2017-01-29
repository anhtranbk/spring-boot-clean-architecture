package com.ezgo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.sql.SQLException;

@Provider
@Configuration
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Context
    public UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable e) {
        logger.error(e.getMessage(), e);

        Response.StatusType status;
        if (e instanceof WebApplicationException) {
            WebApplicationException we = (WebApplicationException) e;
            status = we.getResponse().getStatusInfo();
        } else if (e instanceof SQLException) {
            status = Response.Status.BAD_REQUEST;
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
