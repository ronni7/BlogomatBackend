package com.blogomat.blogomat.model.entities.dataObjects;

import java.util.Date;
import java.util.Set;

public class SearchCriteria {
    private int page;
    private int dataPerPage;
    private Set<String> tags;
    private String author;
    private String title;
    private Date publishDateFrom;
    private Date publishDateTo;

    public SearchCriteria() {
    }

    public SearchCriteria(int page, int dataPerPage, Set<String> tags, String author, String title, Date publishDateFrom, Date publishDateTo) {
        this.page = page;
        this.dataPerPage = dataPerPage;
        this.tags = tags;
        this.author = author;
        this.title = title;
        this.publishDateFrom = publishDateFrom;
        this.publishDateTo = publishDateTo;
    }

    public SearchCriteria(Set<String> tags, String author, String title, Date publishDateFrom, Date publishDateTo) {
        this.tags = tags;
        this.author = author;
        this.title = title;
        this.publishDateFrom = publishDateFrom;
        this.publishDateTo = publishDateTo;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getDataPerPage() {
        return dataPerPage;
    }

    public void setDataPerPage(int dataPerPage) {
        this.dataPerPage = dataPerPage;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDateFrom() {
        return publishDateFrom;
    }

    public void setPublishDateFrom(Date publishDateFrom) {
        this.publishDateFrom = publishDateFrom;
    }

    public Date getPublishDateTo() {
        return publishDateTo;
    }

    public void setPublishDateTo(Date publishDateTo) {
        this.publishDateTo = publishDateTo;
    }
}
