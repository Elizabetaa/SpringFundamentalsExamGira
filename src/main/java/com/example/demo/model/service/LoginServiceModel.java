package com.example.demo.model.service;

public class LoginServiceModel {
    private String email;
    private String password;

    public LoginServiceModel() {
    }


    public String getEmail() {
        return email;
    }

    public LoginServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
