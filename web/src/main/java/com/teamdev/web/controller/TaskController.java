package com.teamdev.web.controller;

import com.teamdev.model.entity.DTO.TaskDTO;
import com.teamdev.service.dao.Tasks;
import com.teamdev.service.dao.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    Tasks taskService;

    @Autowired
    Users userService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public TaskDTO createTask(@RequestBody final TaskDTO task){
        return taskService.createTask(task);
    }
}
