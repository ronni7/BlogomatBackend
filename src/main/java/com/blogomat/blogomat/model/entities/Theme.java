package com.blogomat.blogomat.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Theme implements Serializable {
    public Theme() {
    }

    @Id
    private Integer userID;
    private String themeName;

    public Theme(Integer userID, String themeName) {
        this.userID = userID;
        this.themeName = themeName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }
}

