package com.example.demo.service;

import com.example.demo.model.entities.Classification;
import com.example.demo.model.entities.enums.ClassificationName;

public interface ClassificationService {
    Classification findByName(ClassificationName classification);

    void init();
}
