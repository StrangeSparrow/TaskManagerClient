package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public String getProjects(Model model) {
        List<ProjectDto> projects = projectService.getAllProjects();

        model.addAttribute("projects", projects);

        return "projects";
    }

    @GetMapping("/{id}")
    public String getProject(@PathVariable("id") int id, Model model) {
        ProjectDto project = projectService.getProjectById(id);

        model.addAttribute("project", project);

        return "project";
    }
}
