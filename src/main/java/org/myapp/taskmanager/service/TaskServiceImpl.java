package org.myapp.taskmanager.service;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.myapp.taskmanager.client.TaskClient;
import org.myapp.taskmanager.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskClient taskClient;

    public TaskServiceImpl() {
        taskClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(TaskClient.class))
                .logLevel(Logger.Level.FULL)
                .target(TaskClient.class, "http://localhost:8080/tasks");
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskClient.findAll();
    }

    @Override
    public TaskDto getTaskById(int id) {
        return taskClient.findById(id);
    }
}
