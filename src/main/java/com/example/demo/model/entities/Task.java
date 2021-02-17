package com.example.demo.model.entities;


import com.example.demo.model.entities.enums.Progress;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{
    private String name;
    private String description;
    private Progress process;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }

    @Column(name= "username",unique = true,nullable = false)
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(value = EnumType.STRING)
    public Progress getProcess() {
        return process;
    }

    public Task setProcess(Progress process) {
        this.process = process;
        return this;
    }

    @Column(name = "due_date", nullable = false)
    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @ManyToOne
    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
