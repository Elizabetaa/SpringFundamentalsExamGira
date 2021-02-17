package com.example.demo.service.impl;

import com.example.demo.model.entities.User;
import com.example.demo.model.service.LoginServiceModel;
import com.example.demo.model.service.RegisterServiceModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public String register(RegisterServiceModel registerServiceModel) {
        if (this.userRepository.findByEmail(registerServiceModel.getEmail()).isPresent()){
            return "User email already exist";
        }
        if (this.userRepository.findByUsername(registerServiceModel.getUsername()).isPresent()){
            return "Username already exist";
        }

        User user = this.modelMapper.map(registerServiceModel, User.class);


        this.userRepository.save(user);
        return "";
    }

    @Override
    public boolean login(LoginServiceModel map) {
        User user = this.userRepository.findByEmailAndPassword(map.getEmail(),map.getPassword());
        if (user != null){
            this.currentUser.setUsername(user.getUsername());
        }
        return user != null;
    }

    @Override
    public void logout() {
        this.currentUser.setUsername(null);
    }

    @Override
    public User findByUsername(String username) {

        return this.userRepository.findByUsername(username).orElse(null);
    }


}
