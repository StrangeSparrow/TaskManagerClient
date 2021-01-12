package org.myapp.taskmanager.service;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.myapp.taskmanager.client.UserClient;
import org.myapp.taskmanager.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserClient userClient;

    public UserServiceImpl() {
        userClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserClient.class))
                .logLevel(Logger.Level.FULL)
                .target(UserClient.class, "http://localhost:8080/users");
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userClient.findAll();
    }

    @Override
    public UserDto getUserById(int id) {
        return userClient.findById(id);
    }
}
