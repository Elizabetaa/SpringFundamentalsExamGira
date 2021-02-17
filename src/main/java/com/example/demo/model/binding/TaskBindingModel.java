package com.example.demo.model.binding;

import com.example.demo.model.entities.Classification;
import com.example.demo.model.entities.enums.ClassificationName;
import com.example.demo.model.entities.enums.Progress;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskBindingModel {

    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationName classification;

    public TaskBindingModel() {
    }
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3,max = 20,message = "Name length must be between 3 and 20 characters")

    public String getName() {
        return name;
    }
    public TaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 5,message = "Description min length must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public TaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past!")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
    @NotNull(message = "Classification cannot be empty")
    public ClassificationName getClassification() {
        return classification;
    }

    public TaskBindingModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }
}
