package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskTimeDto {
    private Integer id;
    private Integer hours;
    private String data;
    private Integer user;
    private Integer task;
}