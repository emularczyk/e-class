package com.example.demo.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeMapper {

    public GradeDto gradeToGradeDto(final Grade grade) {
        return GradeDto.builder()
                .gradeType(grade.getGradeType())
                .gradeValue(grade.getGradeValue())
                .date(grade.getDate())
                .weight(grade.getWeight())
                .studentId(grade.getStudentId())
                .subject(grade.getSubject())
                .build();
    }

    public Grade gradeDtoToGrade(final GradeDto gradeDto) {
        return Grade.builder()
                .gradeType(gradeDto.getGradeType())
                .gradeValue(gradeDto.getGradeValue())
                .date(gradeDto.getDate())
                .weight(gradeDto.getWeight())
                .studentId(gradeDto.getStudentId())
                .subject(gradeDto.getSubject())
                .build();
    }

}
