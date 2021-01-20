package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();

    TaskDto getTaskById(int id);

    List<TaskDto> getTaskByUserId(int userId);

    List<TaskDto> getTaskByProjectId(int projectId);

    void addProject(TaskDto task);

    void deleteById(int id);
}
