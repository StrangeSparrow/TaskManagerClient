package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.client.TaskClient;
import org.myapp.taskmanager.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private TaskClient taskClient;

    @Override
    public List<TaskDto> getAllTasks() {
        return taskClient.findAll();
    }

    @Override
    public TaskDto getTaskById(int id) {
        return taskClient.findById(id);
    }

    @Override
    public List<TaskDto> getTaskByUserId(int userId) {
        List<TaskDto> tasks = taskClient.findByExecutor(userId);

        tasks.addAll(taskClient.findByOwner(userId));

        return tasks;
    }
}
