package com.blogomat.blogomat.model.entities;

import com.blogomat.blogomat.enums.GENDER;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "\"user\"")
public class User implements Serializable {
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userID;
    private String login;
    private String username;
    private String password;
    private String email;
    private GENDER sex;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public User(String login, String username, String password, String email, GENDER sex, Role role) {
        this.login = login;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GENDER getSex() {
        return sex;
    }

    public void setSex(GENDER sex) {
        this.sex = sex;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", username='" + username + '\'' +
                ", password=" + password+
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", role=" + role +
                '}';
    }
}

