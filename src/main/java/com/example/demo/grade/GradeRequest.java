package com.example.demo.grade;

import com.example.demo.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

@Builder
@AllArgsConstructor
@Getter
public class GradeRequest {
    private GradeType gradeType;
    private GradeValue gradeValue;
    private float weight;
    private ObjectId studentId;
    private Subject subject;
}
