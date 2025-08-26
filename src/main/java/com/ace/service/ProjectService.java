package com.ace.service;

import com.ace.entity.Project;
import com.ace.excpetion.ProjectNotFoudException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProjectService {

    public Project saveProject(Project project){
        Project.persist(project);
        return project;
    }

    public List<Project> findAllProjects() {
        return Project.findAll().list();
    }

    public Project findById(UUID projectId) {
        return (Project) Project.findByIdOptional(projectId)
                .orElseThrow(ProjectNotFoudException::new);
    }

    public Object updateProject(UUID projectId, Project project) {
        var response = findById(projectId);

        response.title = project.title;

        Project.persist(response);

        return response;
    }

    public void deleteById(UUID projectId) {
        var project = findById(projectId);
        Project.deleteById(project.id);
    }
}
