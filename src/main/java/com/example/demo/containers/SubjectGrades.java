package com.example.demo.containers;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeService;
import com.example.demo.grade.GradeValue;
import com.example.demo.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document
public class SubjectGrades {

    private GradeService gradeService;

    @Id
    private int index;
    private String subject;
    private List<Grade> gradeList;
    private List<String> gradeStringList;
    private float average = 0f;
    private GradeValue finalGrade = GradeValue.ZERO;

    public SubjectGrades(GradeService gradeService, Subject subject, ObjectId studentId) {
        this.gradeService = gradeService;

        this.subject = subject.getName();
        this.gradeList = gradeService.getAllStudentGradesForSubject(studentId, subject);
        this.gradeStringList = gradeList.stream().map(grade -> grade.getGradeValue().getValue()).toList();
        this.average = calculateAverage();
    }

    private float calculateAverage() {
        return (float) (gradeList.stream()
                .mapToDouble(grade -> grade.getGradeValue().getFloatValue())
                .sum() / gradeList.size());
    }
}
