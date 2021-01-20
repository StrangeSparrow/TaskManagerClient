package org.myapp.taskmanager.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private int id;
    private String name;
}
