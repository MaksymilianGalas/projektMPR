package com.example.students.resource;

import com.example.students.data.StudentUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private UUID id;
    private String name;
    private StudentUnit unit;
    private Long index;
    private String email;
    private String phoneNumber;
}
