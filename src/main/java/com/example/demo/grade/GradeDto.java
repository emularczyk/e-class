package com.example.demo.grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class GradeDto {
    private GradeType gradeType;
    private GradeValue gradeValue;
    private OffsetDateTime date;
    private float weight;
    private ObjectId studentId;
}
