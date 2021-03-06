package io.javabrains.springsecurityjpa.domain;

import javax.persistence.*;

@Entity
@Table( name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String username;
    private String password;
    private boolean active ;
    private String roles;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
