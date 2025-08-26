package com.ace.excpetion;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProjectNotFoundExceptionMapper implements ExceptionMapper<ProjectNotFoudException> {

    @Override
    public Response toResponse(ProjectNotFoudException e) {
        return Response.status(Response.Status.NOT_FOUND.getStatusCode(),"Project not foud").build();
    }
}
