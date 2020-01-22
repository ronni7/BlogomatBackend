package com.blogomat.blogomat.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PersonalDataSettings implements Serializable {
    public PersonalDataSettings() {
    }

    @Id
    private Integer userID;
    private boolean username;
    private boolean name;
    private boolean surname;
    private boolean email;
    private boolean registered;
    private boolean postsCount;

    public PersonalDataSettings(Integer userID, boolean username, boolean name, boolean surname, boolean email, boolean registered, boolean postsCount) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registered = registered;
        this.postsCount = postsCount;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public boolean isUsername() {
        return username;
    }

    public void setUsername(boolean username) {
        this.username = username;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isSurname() {
        return surname;
    }

    public void setSurname(boolean surname) {
        this.surname = surname;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isPostsCount() {
        return postsCount;
    }

    public void setPostsCount(boolean postsCount) {
        this.postsCount = postsCount;
    }
}
