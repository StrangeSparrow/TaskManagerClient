package org.myapp.taskmanager.client;

import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskClient {
    @RequestLine("GET /{id}")
    TaskDto findById(@Param("id") int id);

    @RequestLine("GET")
    List<TaskDto> findAll();

    @RequestLine("GET/by-executor/{id}")
    List<TaskDto> findByExecutor(@Param("id") int executorId);

    @RequestLine("GET/by-owner/{id}")
    List<TaskDto> findByOwner(@Param("id") int ownerId);

    @RequestLine("GET/by-project/{id}")
    List<TaskDto> findByProjectId(@Param("id") int projectId);
}
