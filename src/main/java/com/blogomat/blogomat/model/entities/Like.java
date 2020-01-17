package com.blogomat.blogomat.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "\"likeTable\"")
public class Like implements Serializable {
    public Like() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer postID;
    @ElementCollection
    private Set<Integer> usersLiked;

    public Like(Integer postID, Set<Integer> usersLiked) {
        this.postID = postID;
        this.usersLiked = usersLiked;
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

    public Set<Integer> getUsersLiked() {
        return usersLiked;
    }

    public void setUsersLiked(Set<Integer> usersLiked) {
        this.usersLiked = usersLiked;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", postID=" + postID +
                ", usersLiked=" +
                '}';
    }
}

