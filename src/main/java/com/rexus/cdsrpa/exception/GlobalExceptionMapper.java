package com.rexus.cdsrpa.exception;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.jboss.logging.Logger;

import io.vertx.core.http.HttpServerRequest;

@javax.ws.rs.ext.Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Context
    HttpServerRequest request;

    @Inject
    Logger logger;

    @Override
    public Response toResponse(Exception exception) {
        // Use response from WebApplicationException as they are
        if (exception instanceof WebApplicationException ex) {
            // Overwrite error message
            Response originalErrorResponse = ex.getResponse();
            return Response.fromResponse(originalErrorResponse)
                    .entity(originalErrorResponse.getStatusInfo().getReasonPhrase())
                    .build();
        }
        // Special mappings
        if (exception instanceof IllegalArgumentException) {
            return Response.status(400).entity(exception.getMessage()).build();
        }
        logger.fatalf(exception,
                "Failed to process request to: {}",
                request.uri());
        return Response.
                status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(exception.getMessage())
                .build();
    }
}