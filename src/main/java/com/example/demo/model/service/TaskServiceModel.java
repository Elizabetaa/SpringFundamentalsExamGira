package com.example.demo.model.service;

import com.example.demo.model.entities.Classification;
import com.example.demo.model.entities.enums.ClassificationName;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskServiceModel {
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationName classification;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
