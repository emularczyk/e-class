package com.example.demo.finalGrade;

import com.example.demo.grade.GradeValue;
import com.example.demo.subject.Subject;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Getter
@Setter
@Document
public class FinalGrade {
    @Id
    private ObjectId id;
    private Subject subject;
    private GradeValue finalGrade;
    private ObjectId studentId;

    public FinalGrade(Subject subject, ObjectId studentId) {
        this.subject = subject;
        this.studentId = studentId;
        this.finalGrade = GradeValue.ZERO;
    }
}
