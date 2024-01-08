package com.example.demo;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeRepository;
import com.example.demo.grade.GradeType;
import com.example.demo.grade.GradeValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Component
public class InitializeMongoDBData implements CommandLineRunner {

    private final GradeRepository gradeRepository;

    public InitializeMongoDBData(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Grade grade = new Grade(
                GradeType.TEST,
                GradeValue.FOUR,
                OffsetDateTime.now(ZoneId.systemDefault()),
                4,
                UUID.randomUUID()
        );

        System.out.println("Inserting data to mongo...");
        gradeRepository.insert(grade);
    }
}
