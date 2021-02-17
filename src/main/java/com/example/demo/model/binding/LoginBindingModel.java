package com.example.demo.model.binding;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginBindingModel {
    private String email;
    private String password;

    public LoginBindingModel() {
    }

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email")
    public String getEmail() {
        return email;
    }

    public LoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Enter password")
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public LoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }


}
