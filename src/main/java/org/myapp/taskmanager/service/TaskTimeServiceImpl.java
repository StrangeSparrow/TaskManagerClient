package org.myapp.taskmanager.service;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.client.TaskTimeClient;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskTimeServiceImpl implements TaskTimeService {
    TaskTimeClient client;

    @Override
    public List<TaskTimeDto> getAllTime() {
        return client.getAll();
    }

    @Override
    public TaskTimeDto getTimeById(int id) {
        return client.getById(id);
    }

    @Override
    public void deleteTimeById(int id) {
        client.deleteTimeById(id);
    }

    @Override
    public void addTime(TaskTimeDto time) {
        client.addTime(time);
    }

    @Override
    public List<TaskTimeDto> getByTaskId(int id) {
        return client.getByTaskId(id);
    }
}
