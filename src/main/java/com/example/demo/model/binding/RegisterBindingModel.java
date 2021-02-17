package com.example.demo.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterBindingModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterBindingModel() {
    }

    @NotBlank(message = "Enter username")
    @Size(min = 3,max = 20,message = "Username length must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public RegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank(message = "Enter email")
    @Email
    public String getEmail() {
        return email;
    }

    public RegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Enter password")
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public RegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Enter password")
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
