package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProjects();

    ProjectDto getProjectById(int id);

    ProjectDto getProjectByTaskId(int id);

    void addProject(ProjectDto project);

    void deleteById(int id);
}
