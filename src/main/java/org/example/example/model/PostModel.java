package org.example.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class PostModel {
    @Size(min = 4, max = 10)
    @NotBlank
    public String login;
    @NotBlank
    @Size(min = 4, max = 10)
    @Pattern(regexp = "\\d")

    public String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime date;

    public PostModel(String login, String password, LocalDateTime date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }
}
