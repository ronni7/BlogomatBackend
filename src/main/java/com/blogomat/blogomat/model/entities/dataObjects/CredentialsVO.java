package com.blogomat.blogomat.model.entities.dataObjects;

public class CredentialsVO {
    private String login;
    private String password;

    public CredentialsVO() {

    }

    public CredentialsVO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
