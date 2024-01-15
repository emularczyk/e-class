package com.example.demo;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeRepository;
import com.example.demo.grade.GradeType;
import com.example.demo.grade.GradeValue;
import com.example.demo.subject.Subject;
import com.example.demo.subject.SubjectRepository;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitializeMongoDBData implements CommandLineRunner {

    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;
    private List<Subject> subjectList = new ArrayList<>();

    public InitializeMongoDBData(GradeRepository gradeRepository, SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createSubjects();
        createGrades();
    }

    private void createSubjects() {
        subjectList.addAll(
                Arrays.asList(
                        new Subject("Maths"),
                        new Subject("Biology"),
                        new Subject("Chemistry"),
                        new Subject("PE")
                )
        );

        subjectList.stream()
                .forEach(subjectRepository::insert);
    }

    private void createGrades() {
        Grade grade = new Grade(
                GradeType.TEST,
                GradeValue.FOUR,
                OffsetDateTime.now(ZoneId.systemDefault()),
                4,
                new ObjectId(),
                subjectList.get(0)
        );
        Grade grade2 = new Grade(
                GradeType.QUIZ,
                GradeValue.FOUR_PLUS,
                OffsetDateTime.now(ZoneId.systemDefault()),
                3,
                new ObjectId(),
                subjectList.get(0)
        );
        Grade grade3 = new Grade(
                GradeType.ACTIVITY,
                GradeValue.FIVE,
                OffsetDateTime.now(ZoneId.systemDefault()),
                1,
                new ObjectId(),
                subjectList.get(2)
        );
        Grade grade4 = new Grade(
                GradeType.HOMEWORK,
                GradeValue.THREE_PLUS,
                OffsetDateTime.now(ZoneId.systemDefault()),
                2,
                new ObjectId(),
                subjectList.get(1)
        );

        System.out.println("Inserting data to mongo...");
        gradeRepository.insert(grade);
        gradeRepository.insert(grade2);
        gradeRepository.insert(grade3);
        gradeRepository.insert(grade4);
    }
}
