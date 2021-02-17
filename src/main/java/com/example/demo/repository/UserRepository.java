package com.example.demo.repository;

import com.example.demo.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email,String password);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
