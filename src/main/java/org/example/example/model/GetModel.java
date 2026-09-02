package org.example.example.model;

public class GetModel {
    private final String login;
    private final String status;

    public String getLogin() {
        return login;
    }

    public String getStatus() {
        return status;
    }

    public GetModel(String login, String status) {
        this.login = login;
        this.status = status;
    }
}
