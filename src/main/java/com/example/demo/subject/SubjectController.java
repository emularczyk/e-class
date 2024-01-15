package com.example.demo.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("subjects")
@RequiredArgsConstructor
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjectList = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(final Subject subject) {
        subjectService.createSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }
}
