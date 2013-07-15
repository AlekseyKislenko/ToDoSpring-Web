package com.teamdev.model.entity.DTO;

import com.teamdev.model.entity.Task;
import com.teamdev.model.entity.TaskState;

import java.io.Serializable;
import java.util.List;


/**
 * @author Aleksey Kslenko
 */

public class TaskDTO implements Serializable {
    private Long id;
    private String taskText;
    private TaskState taskState;
    private Long taskDate;
    private UserDTO taskUser;

    public TaskDTO(List<Task> tasksByUser) {
    }

    public UserDTO getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(UserDTO taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    private UserDTO taskAssignee;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.taskText = task.getTaskText();
        this.taskDate = task.getTaskDate();
        this.taskUser = new UserDTO(task.getTaskUser());
        this.taskState = task.getTaskState();
        this.taskAssignee = new UserDTO(task.getTaskAssignee());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public Long getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Long taskDate) {
        this.taskDate = taskDate;
    }

    public UserDTO getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(UserDTO taskUser) {
        this.taskUser = taskUser;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskText='" + taskText + '\'' +
                ", taskDate=" + taskDate +
                ", taskUser=" + taskUser +
                ", taskState=" + taskState +
                ", taskAssignee=" + taskAssignee +
                '}';
    }
}
