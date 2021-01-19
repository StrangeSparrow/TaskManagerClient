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
}
