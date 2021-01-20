package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskTimeDto {
    private int id;
    private int hours;
    private String data;
    private int user;
    private int task;
}