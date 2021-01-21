package org.myapp.taskmanager.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.AppConst;
import org.myapp.taskmanager.dto.ProjectDto;

import java.util.List;

public interface ProjectClient {
    @RequestLine("GET /{id}")
    ProjectDto findById(@Param("id") int id);

    @RequestLine("GET")
    List<ProjectDto> findAll();

    @RequestLine("GET/by-task/{id}")
    ProjectDto findProjectByTaskId(@Param("id") int id);

    @RequestLine("POST")
    @Headers(AppConst.JSON_TYPE)
    void addProject(ProjectDto project);

    @RequestLine("DELETE/{id}")
    void deleteById(@Param("id") int id);

    @RequestLine("PUT")
    @Headers(AppConst.JSON_TYPE)
    void updateProject(ProjectDto project);
}
