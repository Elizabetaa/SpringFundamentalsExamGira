package com.example.demo.service.impl;

import com.example.demo.model.entities.Classification;
import com.example.demo.model.entities.enums.ClassificationName;
import com.example.demo.repository.ClassificationRepository;
import com.example.demo.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public Classification findByName(ClassificationName classification) {

        return this.classificationRepository.findByClassificationName(classification).orElse(null);
    }

    @Override
    public void init() {
        if (classificationRepository.count() == 0){

            Arrays.stream(ClassificationName.values()).forEach(c -> {
                Classification classification = new Classification();
                classification.setClassificationName(c).setDescription("Description for "+ c);
                this.classificationRepository.save(classification);
            });
        }

    }
}
