package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.client.ProjectClient;
import org.myapp.taskmanager.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectClient projectClient;

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectClient.findAll();
    }

    @Override
    public ProjectDto getProjectById(int id) {
        return projectClient.findById(id);
    }

    @Override
    public ProjectDto getProjectByTaskId(int id) {
        ProjectDto project = projectClient.findProjectByTaskId(id);

        return project;
    }
}
