package com.blogomat.blogomat.model.VO;

public class UserContextVO {
    private Integer id;
    private String role;
    private String username;

    public UserContextVO() {

    }

    public UserContextVO(Integer id, String role, String username) {
        this.id = id;
        this.role = role;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
