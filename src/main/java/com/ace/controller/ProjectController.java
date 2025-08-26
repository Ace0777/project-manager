package com.ace.controller;

import com.ace.entity.Project;
import com.ace.service.ProjectService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GET
    public Response findAll(){
        var projects = service.findAllProjects();
        return Response.ok(projects).build();
    }

    @POST
    @Transactional
    public Response save(Project project){
        return Response.ok(service.saveProject(project)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") UUID projectId, Project project){
        return Response.ok(service.updateProject(projectId,project)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID projectId){
        return Response.ok(service.findById(projectId)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") UUID projectId){
      service.deleteById(projectId);
      return Response.noContent().build();
    }

    @PUT
    @Path("/{id}/move")
    @Transactional
    public Response moveProject(@PathParam("id") UUID projectId, @QueryParam("status") String newStatus){
        return Response.ok(service.moveProject(projectId,newStatus)).build();
    }


}
