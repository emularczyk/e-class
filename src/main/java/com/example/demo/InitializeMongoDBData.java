package com.example.demo;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeRepository;
import com.example.demo.grade.GradeType;
import com.example.demo.grade.GradeValue;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

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
                new ObjectId()
        );
        Grade grade2 = new Grade(
                GradeType.QUIZ,
                GradeValue.FOUR_PLUS,
                OffsetDateTime.now(ZoneId.systemDefault()),
                3,
                new ObjectId()
        );
        Grade grade3 = new Grade(
                GradeType.ACTIVITY,
                GradeValue.FIVE,
                OffsetDateTime.now(ZoneId.systemDefault()),
                1,
                new ObjectId()
        );
        Grade grade4 = new Grade(
                GradeType.HOMEWORK,
                GradeValue.THREE_PLUS,
                OffsetDateTime.now(ZoneId.systemDefault()),
                2,
                new ObjectId()
        );

        System.out.println("Inserting data to mongo...");
        gradeRepository.insert(grade);
        gradeRepository.insert(grade2);
        gradeRepository.insert(grade3);
        gradeRepository.insert(grade4);
    }
}
