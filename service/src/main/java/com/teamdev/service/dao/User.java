package com.teamdev.service.dao;

import com.teamdev.model.entity.DTO.UserDTO;

import java.util.List;

public interface User {

    public UserDTO createUser(String userLogin, String userPassword);

    public UserDTO getUserById(Long id);

    public List<UserDTO> getAllUsers();

    public List<UserDTO> getUserList(List resultList);

    public boolean deleteUserById(Long id);

}
