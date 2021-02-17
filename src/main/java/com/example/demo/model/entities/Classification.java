package com.example.demo.model.entities;

import com.example.demo.model.entities.enums.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{
    private ClassificationName classificationName;
    private String description;

    public Classification() {
    }

    public Classification(ClassificationName classificationName) {
        this.classificationName = classificationName;
    }

    @Enumerated(value = EnumType.STRING)
    public ClassificationName getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(ClassificationName classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
