package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.TaskDto;
import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.service.TaskService;
import org.myapp.taskmanager.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    @GetMapping
    public String getUsers(Model model) {
        List<UserDto> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable("id") int id) {
        UserDto user = userService.getUserById(id);
        List<TaskDto> tasks = taskService.getTaskByUserId(id);

        model.addAttribute("user", user);
        model.addAttribute("tasks", tasks);

        return "user";
    }
}
