package org.myapp.taskmanager.client;

import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.dto.UserDto;

import java.util.List;

public interface UserClient {
    @RequestLine("GET /{id}")
    UserDto findById(@Param("id") int id);

    @RequestLine("GET")
    List<UserDto> findAll();

    @RequestLine("GET/by-task/{id}/owner")
    UserDto getOwnerByTaskId(@Param("id") int id);

    @RequestLine("GET/by-task/{id}/executor")
    UserDto getExecutorByTaskId(@Param("id") int id);

    @RequestLine("GET/owners")
    List<UserDto> getOwners();

    @RequestLine("GET/executors")
    List<UserDto> getExecutors();
}
