package org.myapp.taskmanager.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private int id;
    private String name;
    private String status;
    private int owner;
    private int executor;
    private int project;
}
