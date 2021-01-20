package org.myapp.taskmanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProjectDto {
    private int id;
    private String name;
}
