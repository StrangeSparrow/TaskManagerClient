package org.myapp.taskmanager.service;

import org.myapp.taskmanager.dto.TaskTimeDto;

import java.util.List;

public interface TaskTimeService {
    List<TaskTimeDto> getAllTime();

    TaskTimeDto getTimeById(int id);

    void deleteTimeById(int id);

    void addTime(TaskTimeDto time);
}
