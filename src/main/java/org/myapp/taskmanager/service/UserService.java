package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto getOwnerByTaskId(int id);

    UserDto getExecutorByTaskId(int id);
}
