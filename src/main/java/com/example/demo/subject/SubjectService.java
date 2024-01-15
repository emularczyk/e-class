package com.example.demo.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.insert(
                Subject.builder()
                        .name(subject.getName())
                        .build()
        );
    }
}
