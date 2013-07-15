package com.teamdev.service.dao;

import com.teamdev.model.entity.DTO.TaskDTO;
import com.teamdev.model.entity.DTO.UserDTO;
import com.teamdev.model.entity.TaskState;

import java.util.List;

public interface Task {

    public TaskDTO createTask(String taskText, UserDTO userDTO);

    public boolean deleteTaskById(Long id);

    public boolean deleteTask(TaskDTO task);

    public TaskDTO getTaskById(Long id);

    public List<TaskDTO> getTasksByUser(UserDTO user);

    public List<TaskDTO> getTaskList(List<TaskDTO> tasksByUser);

    public List<TaskDTO> getTasksByAssignee(UserDTO user);

    public List<TaskDTO> getTaskAssigneeList(List<TaskDTO> tasksByAssignee);

    public boolean changeTaskState(Long id, TaskState newTaskState);

    public boolean changeTaskText(Long id, String newTaskText);

    public boolean changeTaskAssignee(Long id, UserDTO taskAssignee);

}
