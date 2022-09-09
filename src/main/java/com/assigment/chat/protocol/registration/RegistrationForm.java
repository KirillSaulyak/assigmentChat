package com.assigment.chat.protocol.registration;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Builder
@Data
public class RegistrationForm {
    @NotBlank(message = "Please, write the name")
    private String name;
    @NotBlank(message = "Please, write the login")
    private String login;
    @NotBlank(message = "Please, write the password")
    private String password;
    @NotBlank(message = "Please, write the password again")
    private String passwordAgain;
}
