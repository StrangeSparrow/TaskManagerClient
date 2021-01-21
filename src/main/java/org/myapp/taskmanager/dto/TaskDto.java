package org.myapp.taskmanager.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private String name;
    private String status;
    private Integer owner;
    private Integer executor;
    private Integer project;

    public enum Status {
        start, execute, finish
    }
}
