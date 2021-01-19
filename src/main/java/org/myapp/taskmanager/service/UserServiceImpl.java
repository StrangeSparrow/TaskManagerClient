package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.client.UserClient;
import org.myapp.taskmanager.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserClient userClient;

    @Override
    public List<UserDto> getAllUsers() {
        return userClient.findAll();
    }

    @Override
    public UserDto getUserById(int id) {
        return userClient.findById(id);
    }

    @Override
    public UserDto getOwnerByTaskId(int id) {
        UserDto owner = userClient.getOwnerByTaskId(id);

        return owner;
    }

    @Override
    public UserDto getExecutorByTaskId(int id) {
        UserDto executor = userClient.getExecutorByTaskId(id);

        return executor;
    }
}
