package com.blogomat.blogomat.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SocialMediaSettings implements Serializable {
    public SocialMediaSettings() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userID;
    private Boolean facebook;
    private Boolean instagram;
    private Boolean snapchat;
    private Boolean twitter;

    public SocialMediaSettings(Integer userID, Boolean facebook, Boolean instagram, Boolean snapchat, Boolean twitter) {
        this.userID = userID;
        this.facebook = facebook;
        this.instagram = instagram;
        this.snapchat = snapchat;
        this.twitter = twitter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Boolean getFacebook() {
        return facebook;
    }

    public void setFacebook(Boolean facebook) {
        this.facebook = facebook;
    }

    public Boolean getInstagram() {
        return instagram;
    }

    public void setInstagram(Boolean instagram) {
        this.instagram = instagram;
    }

    public Boolean getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(Boolean snapchat) {
        this.snapchat = snapchat;
    }

    public Boolean getTwitter() {
        return twitter;
    }

    public void setTwitter(Boolean twitter) {
        this.twitter = twitter;
    }
}
