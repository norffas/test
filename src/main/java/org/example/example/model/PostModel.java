package org.example.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PostModel {
    private String login;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    public PostModel(String login, String password, LocalDateTime date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }
}
