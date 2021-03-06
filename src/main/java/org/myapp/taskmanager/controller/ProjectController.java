package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.service.ProjectService;
import org.myapp.taskmanager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;
    private TaskService taskService;

    @GetMapping
    public String getProjects(Model model) {
        List<ProjectDto> projects = projectService.getAllProjects();

        model.addAttribute("projects", projects);

        return "projects";
    }

    @GetMapping("/{id}")
    public String getProject(@PathVariable("id") int id, Model model) {
        ProjectDto project = projectService.getProjectById(id);

        List<TaskDto> tasks = taskService.getTaskByProjectId(project.getId());

        model.addAttribute("project", project);
        model.addAttribute("tasks", tasks);

        return "project";
    }

    @GetMapping("/add")
    public String formAddProject(Model model) {
        model.addAttribute("project", new ProjectDto());

        return "project_add";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute(name = "project") ProjectDto project, Model model) {

        projectService.addProject(project);

        return "redirect:/projects";
    }

    @GetMapping("/{id}/delete")
    public String deleteProject(@PathVariable("id") int id) {
        projectService.deleteById(id);

        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String formEditProject(@PathVariable("id") int id, Model model) {
        ProjectDto project = projectService.getProjectById(id);

        model.addAttribute("project", project);

        return "project_edit";
    }

    @PostMapping("/edit")
    public String editProject(@ModelAttribute ProjectDto project) {

        projectService.updateProject(project);

        return "redirect:/projects/" + project.getId();
    }
}
