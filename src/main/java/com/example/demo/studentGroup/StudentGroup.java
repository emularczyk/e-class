package com.example.demo.studentGroup;

import com.example.demo.subject.Subject;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Document
public class StudentGroup {
    @Id
    private String name;
    private Subject subject;
    private ObjectId teacherId;
}
