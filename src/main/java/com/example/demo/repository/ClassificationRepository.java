package com.example.demo.repository;

import com.example.demo.model.entities.Classification;
import com.example.demo.model.entities.enums.ClassificationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    Optional<Classification> findByClassificationName(ClassificationName classificationName);
}
