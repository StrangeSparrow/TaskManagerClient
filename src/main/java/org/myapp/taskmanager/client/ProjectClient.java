package org.myapp.taskmanager.client;

import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.dto.ProjectDto;

import java.util.List;

public interface ProjectClient {
    @RequestLine("GET /{id}")
    ProjectDto findById(@Param("id") int id);

    @RequestLine("GET")
    List<ProjectDto> findAll();
}
