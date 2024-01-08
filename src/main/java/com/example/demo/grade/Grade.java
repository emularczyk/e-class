package com.example.demo.grade;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Document
public class Grade {
    @Id
    private UUID gradeId;
    private GradeType gradeType;
    private GradeValue gradeValue;
    private OffsetDateTime date;
    private float weight;
    private UUID studentId;

    public Grade(GradeType gradeType, GradeValue gradeValue, OffsetDateTime date, float weight, UUID studentId) {
        this.gradeType = gradeType;
        this.gradeValue = gradeValue;
        this.date = date;
        this.weight = weight;
        this.studentId = studentId;
    }
}
