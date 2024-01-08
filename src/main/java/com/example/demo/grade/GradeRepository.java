package com.example.demo.grade;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GradeRepository extends MongoRepository<Grade, ObjectId> {
}