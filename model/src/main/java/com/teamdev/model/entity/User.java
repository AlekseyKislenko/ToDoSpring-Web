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
    private String username;

    private String password;

    private UserAuthority authority;

    private Boolean enabled;

    @OneToMany(mappedBy = "taskUser",cascade={CascadeType.ALL})
    private List<Task> tasks;

    @OneToMany(mappedBy = "taskAssignee",cascade={CascadeType.ALL})
    private List<Task> taskAssignee;

    public User() {
    }

    public User(String username, String password, UserAuthority authority, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.enabled = enabled;
    }

    public User(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authority = user.getAuthority();
        this.enabled = user.getEnabled();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
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

    public List<Task> getTasksByUserAssignee(User user) {
        return taskAssignee;
    }
}
