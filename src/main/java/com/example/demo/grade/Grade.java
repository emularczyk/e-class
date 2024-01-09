package com.example.demo.grade;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Grade {
    @Id
    private ObjectId gradeId;
    private GradeType gradeType;
    private GradeValue gradeValue;
    private OffsetDateTime date;
    private float weight;
    private ObjectId studentId;

    public Grade(GradeType gradeType, GradeValue gradeValue, OffsetDateTime date, float weight, ObjectId studentId) {
        this.gradeType = gradeType;
        this.gradeValue = gradeValue;
        this.date = date;
        this.weight = weight;
        this.studentId = studentId;
    }
}
