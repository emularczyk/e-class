package com.example.demo.subject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Subject {
    @Id
    private String name;
}
