package org.example.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PostModelDTO {
    @Size(min = 4, max = 10)
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 4, max = 10)
    @Pattern(regexp = "\\d+")
    private String password;

    public PostModelDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
