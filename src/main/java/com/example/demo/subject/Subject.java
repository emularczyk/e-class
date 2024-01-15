package com.example.demo.subject;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Document
public class Subject {
    @Id
    private String name;
}
