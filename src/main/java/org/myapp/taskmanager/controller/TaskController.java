package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.ProjectDto;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.service.ProjectService;
import org.myapp.taskmanager.service.TaskService;
import org.myapp.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private UserService userService;
    private ProjectService projectService;

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

        model.addAttribute("task", task);
        model.addAttribute("owner", owner);
        model.addAttribute("executor", executor);
        model.addAttribute("project", project);

        return "task";
    }
}
