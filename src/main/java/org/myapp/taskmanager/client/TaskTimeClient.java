package org.myapp.taskmanager.client;

import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.dto.TaskTimeDto;

import java.util.List;

public interface TaskTimeClient {
    @RequestLine("GET")
    List<TaskTimeDto> getAll();

    @RequestLine("GET/by-task/{id}")
    List<TaskTimeDto> getByTaskId(@Param("id") int id);

    @RequestLine("GET/{id}")
    TaskTimeDto getById(@Param("id") int id);
}
