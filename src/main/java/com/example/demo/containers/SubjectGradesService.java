package com.example.demo.containers;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeRepository;
import com.example.demo.grade.GradeService;
import com.example.demo.subject.Subject;
import com.example.demo.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SubjectGradesService {
    private final SubjectRepository subjectRepository;
    private final GradeService gradeService;

    public List<SubjectGrades> getAllSubjectGradesForStudent(ObjectId studentId) {
        final List<SubjectGrades> subjectGrades = new ArrayList<>();
        List<Subject> subjectList = subjectRepository.findAll(); // TODO: students can have different subjects
        for (Subject subject : subjectList) {
            subjectGrades.add(new SubjectGrades(gradeService, subject, studentId));
        }
        return subjectGrades;
    }

}
