package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();

    TaskDto getTaskById(int id);

    List<TaskDto> getTaskByUserId(int userId);
}
