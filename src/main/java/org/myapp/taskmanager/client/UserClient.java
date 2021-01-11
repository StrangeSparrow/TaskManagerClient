package org.myapp.taskmanager.client;

import feign.Param;
import feign.RequestLine;
import org.myapp.taskmanager.dto.UserDto;

import java.util.List;

public interface UserClient {
    @RequestLine("GET /{id}")
    UserDto findById(@Param("id") String id);

    @RequestLine("GET")
    List<UserDto> findAll();
}
