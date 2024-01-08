package com.example.demo.grade;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GradeRepository extends MongoRepository<Grade, UUID> {
}