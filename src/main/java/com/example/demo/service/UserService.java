package com.example.demo.service;

import com.example.demo.model.entities.User;
import com.example.demo.model.service.LoginServiceModel;
import com.example.demo.model.service.RegisterServiceModel;

public interface UserService {
    String register(RegisterServiceModel map);

    boolean login(LoginServiceModel map);

    void logout();

    User findByUsername(String username);
}
