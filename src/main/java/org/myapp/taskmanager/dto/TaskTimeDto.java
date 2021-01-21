package org.myapp.taskmanager.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
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