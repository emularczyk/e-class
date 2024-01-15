package com.example.demo.grade;

import com.example.demo.exceptions.GradeNotFoundException;
import com.example.demo.subject.Subject;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public List<Grade> getAllStudentGradesForSubject(final ObjectId studentId, final Subject subject) {
        return gradeRepository.findAll()
                .stream()
                .filter(grade -> grade.getStudentId().equals(studentId))
                .filter(grade -> grade.getSubject().getName().equals(subject.getName()))
                .collect(Collectors.toList());
    }

    public Grade getGradeById(final ObjectId gradeId) {
        return gradeRepository.findById(gradeId)
                .orElseThrow(() -> new GradeNotFoundException(gradeId));
    }

    public Grade createGrade(final GradeRequest gradeRequest) {
        return gradeRepository.insert(
                Grade.builder()
                        .gradeType(gradeRequest.getGradeType())
                        .gradeValue(gradeRequest.getGradeValue())
                        .date(OffsetDateTime.now())
                        .weight(gradeRequest.getWeight())
                        .studentId(gradeRequest.getStudentId())
                        .subject(gradeRequest.getSubject())
                        .build()
        );
    }

    public Grade updateGradeById(final ObjectId gradeId, final GradeRequest gradeRequest) {
        Grade updatedGrade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new GradeNotFoundException(gradeId));

        return gradeRepository.save(
                Grade.builder()
                        .gradeType(gradeRequest.getGradeType())
                        .gradeValue(gradeRequest.getGradeValue())
                        .date(OffsetDateTime.now())
                        .weight(gradeRequest.getWeight())
                        .studentId(gradeRequest.getStudentId())
                        .subject(gradeRequest.getSubject())
                        .build()
        );
    }

    public void deleteGradeById(final ObjectId gradeId) {
        if (!gradeRepository.existsById(gradeId)) {
            throw new GradeNotFoundException(gradeId);
        }

        gradeRepository.deleteById(gradeId);
    }

}
