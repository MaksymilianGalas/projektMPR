package com.example.students.data;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Assignment {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    private String description;

    private String dueDate;
    private int weight;
    private int grade;

    @ManyToOne
    private Student student;


}
