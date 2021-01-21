package org.myapp.taskmanager.controller;

import lombok.AllArgsConstructor;
import org.myapp.taskmanager.dto.TaskTimeDto;
import org.myapp.taskmanager.service.TaskTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/time")
public class TaskTimeController {
    private final TaskTimeService service;

    @PostMapping("/add")
    public String addTime(@ModelAttribute TaskTimeDto time) {
        service.addTime(time);

        return "redirect:/tasks/" + time.getTask();
    }

    @GetMapping("/{id}/delete")
    public String deleteTimeById(@PathVariable("id") int id, @RequestHeader(name = "Referer") String ref) {
        service.deleteTimeById(id);

        return "redirect:/" + ref.substring(ref.lastIndexOf("tasks"));
    }
}
