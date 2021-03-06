package com.teamdev.web.controller;

import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.service.dao.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    Users userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public UserDTO createUser(@RequestBody final UserDTO user){
        return userService.createUser(user.getUsername(), user.getPassword(), user.getAuthority(), user.getEnabled());
    }
}
