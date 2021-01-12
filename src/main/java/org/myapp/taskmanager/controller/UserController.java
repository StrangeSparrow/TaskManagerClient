package org.myapp.taskmanager.controller;

import org.myapp.taskmanager.dto.UserDto;
import org.myapp.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        List<UserDto> users = userService.getAllUsers();

        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable("id") int id) {
        UserDto user = userService.getUserById(id);

        model.addAttribute("user", user);

        return "user";
    }
}
