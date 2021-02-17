package com.example.demo.model.service;

public class RegisterServiceModel {


    private String username;
    private String email;
    private String password;

    public RegisterServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
