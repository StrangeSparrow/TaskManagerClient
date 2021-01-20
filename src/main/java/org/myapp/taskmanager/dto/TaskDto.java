package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskDto {
    private int id;
    private String name;
    private String status;
}
