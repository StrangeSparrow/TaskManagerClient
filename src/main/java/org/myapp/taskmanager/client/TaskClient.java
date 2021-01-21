package org.myapp.taskmanager.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.AppConst;
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

    @RequestLine("POST")
    @Headers(AppConst.JSON_TYPE)
    void addTask(TaskDto task);

    @RequestLine("DELETE/{id}")
    void deleteById(@Param("id") int id);

    @RequestLine("PUT")
    @Headers(AppConst.JSON_TYPE)
    void updateTask(TaskDto task);
}
