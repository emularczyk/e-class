package com.example.demo.exceptions;

import org.bson.types.ObjectId;

import java.util.UUID;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(ObjectId gradeId) {
        super("No grade with id = " + gradeId);
    }
}
