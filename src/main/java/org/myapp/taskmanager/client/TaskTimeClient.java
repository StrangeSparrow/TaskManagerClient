package org.myapp.taskmanager.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.AppConst;
import org.myapp.taskmanager.dto.TaskTimeDto;

import java.util.List;

public interface TaskTimeClient {
    @RequestLine("GET")
    List<TaskTimeDto> getAll();

    @RequestLine("GET/by-task/{id}")
    List<TaskTimeDto> getByTaskId(@Param("id") int id);

    @RequestLine("GET/{id}")
    TaskTimeDto getById(@Param("id") int id);

    @RequestLine("POST")
    @Headers(AppConst.JSON_TYPE)
    void addTime(TaskTimeDto time);
}
