package com.teamdev.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Aleksey Kslenko
 */

@Entity
@NamedQueries({
        @NamedQuery(name="getTaskByUser", query="from Task where taskUser = :user "),
        @NamedQuery(name="getTaskByAssignee", query="from Task where taskAssignee = :user"),
        @NamedQuery(name="changeTaskState", query="update Task set taskState = :taskState where id = :id"),
        @NamedQuery(name="changeTaskText", query="update Task set taskText = :taskText where id = :id"),
        @NamedQuery(name="changeTaskAssignee", query="update Task set taskAssignee = :taskAssignee where id = :id")
})
public class Task implements Persistent {

    @Id
    @GeneratedValue
    private Long id;

    private String taskText;

    @Enumerated(EnumType.STRING)
    private TaskState taskState;

    private Long taskDate;

    @ManyToOne
    private User taskUser;

    @ManyToOne
    private User taskAssignee;

    public Task() {
    }

    public User getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(User taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public User getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(User user) {
        this.taskUser = user;
    }

    @Override
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String task) {
        this.taskText = task;
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

    public Long setTaskDate() {
        taskDate = new Date().getTime();
        return taskDate;
    }
}
