package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.service.ProjectService;
import org.myapp.taskmanager.service.TaskService;
import org.myapp.taskmanager.service.TaskTimeService;
import org.myapp.taskmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskTimeService taskTimeService;

    @GetMapping
    public String getTasks(Model model) {
        List<TaskDto> tasks = taskService.getAllTasks();

        model.addAttribute("tasks", tasks);

        return "tasks";
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") int id, Model model) {
        TaskDto task = taskService.getTaskById(id);

        UserDto owner = userService.getOwnerByTaskId(task.getId());
        UserDto executor = userService.getExecutorByTaskId(task.getId());

        ProjectDto project = projectService.getProjectByTaskId(task.getId());

        List<TaskTimeDto> time = taskTimeService.getByTaskId(task.getId());

        model.addAttribute("task", task);
        model.addAttribute("owner", owner);
        model.addAttribute("executor", executor);
        model.addAttribute("project", project);
        model.addAttribute("time", time);
        model.addAttribute("taskTime", new TaskTimeDto());

        return "task";
    }

    @GetMapping("/add")
    public String formAddProject(Model model) {
        model.addAttribute("task", new TaskDto());

        return "task_add";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute TaskDto task, Model model) {
        task.setStatus("start");
        taskService.addTask(task);

        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteProject(@PathVariable("id") int id) {
        taskService.deleteById(id);

        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String formEditProject(@PathVariable("id") int id, Model model) {
        TaskDto task = taskService.getTaskById(id);

        List<UserDto> owners = userService.getOwners();
        List<UserDto> executors = userService.getExecutors();

        List<ProjectDto> projects = projectService.getAllProjects();

        model.addAttribute("task", task);
        model.addAttribute("owners", owners);
        model.addAttribute("executors", executors);
        model.addAttribute("projects", projects);

        return "task_edit";
    }

    @PostMapping("/edit")
    public String editProject(@ModelAttribute TaskDto task) {

//        TaskDto task = TaskDto.builder().id(id).name(name).status(status).owner(owner).executor(executor).project(project).build();

        taskService.updateTask(task);

        return "redirect:/tasks/" + task.getId();
    }
}
