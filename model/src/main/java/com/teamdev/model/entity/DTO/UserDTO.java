package com.teamdev.model.entity.DTO;

import com.teamdev.model.entity.User;
import com.teamdev.model.entity.UserAuthority;

import java.io.Serializable;

/**
 * @author Aleksey Kslenko
 */

public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private UserAuthority authority;
    private Boolean enabled;

    private TaskDTO tasks;
    private TaskDTO tasksAssignee;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authority = user.getAuthority();
        this.enabled = user.getEnabled();
        this.tasks = new TaskDTO(user.getTasksByUser(user));
        this.tasksAssignee = new TaskDTO(user.getTasksByUserAssignee(user));
    }

    public UserDTO(Long id, String username, String password, UserAuthority authority, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.enabled = enabled;
    }

    public UserDTO(String username, String password, UserAuthority authority, Boolean enabled) {

        this.username = username;
        this.password = password;
        this.authority = authority;
        this.enabled = enabled;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public UserAuthority getAuthority() {
        return authority;
    }

    public void setAuthority(UserAuthority authority) {
        this.authority = authority;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
