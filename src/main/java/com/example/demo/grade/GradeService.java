package com.example.demo.grade;

import com.example.demo.exceptions.GradeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
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
