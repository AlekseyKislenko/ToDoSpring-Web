package com.teamdev.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Aleksey Kslenko
 */

@Entity
@NamedQueries({
        @NamedQuery(name="deleteUserById", query="from User u")
})

public class User implements Persistent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;

    private String password;

    @OneToMany(mappedBy = "taskUser",cascade={CascadeType.ALL})
    private List<Task> tasks;

    @OneToMany(mappedBy = "taskAssignee",cascade={CascadeType.ALL})
    private List<Task> taskAssignee;

    public User() {
    }

    public List<Task> getTasksByUser (User user){
        return tasks;
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

    public List<Task> getTasksByUserAssignee(User user) {
        return taskAssignee;
    }
}
