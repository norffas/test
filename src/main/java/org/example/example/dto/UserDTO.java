package org.example.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {
    @Size(min = 4, max = 10)
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 4, max = 10)
    @Pattern(regexp = "\\d+")
    private String password;
    @NotBlank
    @Size(min = 7, max = 20)
    @Email
    private String email;

}
