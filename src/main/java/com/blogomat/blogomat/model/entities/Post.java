package com.blogomat.blogomat.model.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @ElementCollection
    private Set<String> tags;
    @Length(max = 16384)
    private String postContent;
    private Date publishDate;
    private String author;

    public Post(String title, Set<String> tags, String postContent, Date publishDate, String author) {
        this.title = title;
        this.tags = tags;
        this.postContent = postContent;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getPostContent() {
        return postContent;
    }

    public Post() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tags=" +/* tags +*/
                ", postContent='" + postContent + '\'' +
                ", publishDate=" + publishDate +
                ", author='" + author + '\'' +
                '}';
    }
}
