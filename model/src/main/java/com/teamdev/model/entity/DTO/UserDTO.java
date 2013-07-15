package com.teamdev.model.entity.DTO;

import com.teamdev.model.entity.User;

import java.io.Serializable;

/**
 * @author Aleksey Kslenko
 */

public class UserDTO implements Serializable {
    private Long id;
    private String login;
    private String password;
    private TaskDTO tasks;
    private TaskDTO tasksAssignee;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.tasks = new TaskDTO(user.getTasksByUser(user));
        this.tasksAssignee = new TaskDTO(user.getTasksByUserAssignee(user));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaskDTO getTasks() {
        return tasks;
    }

    public void setTasks(TaskDTO tasks) {
        this.tasks = tasks;
    }

    public TaskDTO getTasksAssignee() {
        return tasksAssignee;
    }

    public void setTasksAssignee(TaskDTO tasksAssignee) {
        this.tasksAssignee = tasksAssignee;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
