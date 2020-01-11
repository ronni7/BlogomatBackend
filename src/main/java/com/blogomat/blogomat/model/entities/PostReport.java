package com.blogomat.blogomat.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class PostReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer postID;
    private Integer reporterID;
    private String subject;
    private String customSubject;
    private String message;

    public PostReport() {
    }

    public PostReport(Integer postID, Integer reporterID, String subject, String customSubject, String message) {
        this.postID = postID;
        this.reporterID = reporterID;
        this.subject = subject;
        this.customSubject = customSubject;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getReporterID() {
        return reporterID;
    }

    public void setReporterID(Integer reporterID) {
        this.reporterID = reporterID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCustomSubject() {
        return customSubject;
    }

    public void setCustomSubject(String customSubject) {
        this.customSubject = customSubject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PostReport{" +
                "id=" + id +
                ", postID=" + postID +
                ", reporterID=" + reporterID +
                ", subject='" + subject + '\'' +
                ", customSubject='" + customSubject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
