package org.myapp.taskmanager.controller;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.myapp.taskmanager.client.UserClient;
import org.myapp.taskmanager.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    UserClient userClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(UserClient.class))
            .logLevel(Logger.Level.FULL)
            .target(UserClient.class, "http://localhost:8080/users");

    @GetMapping
    public String getUsers(Model model) {
        List<UserDto> users = userClient.findAll();

        model.addAttribute("users", users);

        return "users";
    }
}
