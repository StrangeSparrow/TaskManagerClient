package org.myapp.taskmanager.service;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.myapp.taskmanager.client.ProjectClient;
import org.myapp.taskmanager.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectClient projectClient;

    public ProjectServiceImpl() {
        projectClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ProjectClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ProjectClient.class, "http://localhost:8080/tasks");
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectClient.findAll();
    }

    @Override
    public ProjectDto getProjectById(int id) {
        return projectClient.findById(id);
    }
}
