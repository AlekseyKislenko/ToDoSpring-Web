package com.teamdev.web.controller;

import com.teamdev.service.dao.Task;
import com.teamdev.service.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    Task taskService;

    @Autowired
    User userService;


}
