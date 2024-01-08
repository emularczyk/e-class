package com.example.demo.grade;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServiceHandler {
   // private final GradeValidator gradeValidator; // TODO
    private final GradeService gradeService;
    private final GradeMapper gradeMapper;

    public List<GradeDto> getAllGrades() {
        List<Grade> gradeList = gradeService.getAllGrades();
        return gradeList.stream()
                .map(gradeMapper::gradeToGradeDto)
                .collect(Collectors.toList());
    }

    public GradeDto getGradeById(final ObjectId gradeId) {
        Grade grade = gradeService.getGradeById(gradeId);
        return gradeMapper.gradeToGradeDto(grade);
    }

    public GradeDto createGrade(final GradeRequest gradeRequest) {
        Grade grade = gradeService.createGrade(gradeRequest);
        return gradeMapper.gradeToGradeDto(grade);
    }

    public GradeDto updateGradeById(final ObjectId gradeId, final GradeRequest gradeRequest) {
        Grade grade = gradeService.updateGradeById(gradeId, gradeRequest);
        return gradeMapper.gradeToGradeDto(grade);
    }

    public void deleteGradeById(final ObjectId gradeId) {
        gradeService.deleteGradeById(gradeId);
    }
}
