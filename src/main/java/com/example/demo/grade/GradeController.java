package com.example.demo.grade;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/grades")
@RequiredArgsConstructor
@RestController
public class GradeController {
    private final GradeServiceHandler gradeServiceHandler;

    @GetMapping
    public ResponseEntity<List<GradeDto>> getAllGrades() {
        List<GradeDto> gradeDtoList = gradeServiceHandler.getAllGrades();
        return new ResponseEntity<>(gradeDtoList, HttpStatus.OK);
    }

    @GetMapping("/{gradeId}")
    public ResponseEntity<GradeDto> getGradeById(@PathVariable("gradeId") final ObjectId gradeId) {
        GradeDto gradeDto = gradeServiceHandler.getGradeById(gradeId);
        return new ResponseEntity<>(gradeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GradeDto> createGrade(final GradeRequest gradeRequest) {
        GradeDto gradeDto = gradeServiceHandler.createGrade(gradeRequest);
        return new ResponseEntity<>(gradeDto, HttpStatus.CREATED);
    }

    @PutMapping("/{gradeId}")
    public ResponseEntity<GradeDto> updateGradeById(@PathVariable("gradeId") final ObjectId gradeId, final GradeRequest gradeRequest) {
        GradeDto gradeDto = gradeServiceHandler.updateGradeById(gradeId, gradeRequest);
        return new ResponseEntity<>(gradeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<HttpStatus> deleteGradeById(@PathVariable("gradeId") final ObjectId gradeId) {
        gradeServiceHandler.deleteGradeById(gradeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
