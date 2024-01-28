package com.example.students.resource;

import com.example.students.data.StudentUnit;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudent {

    @NotBlank
    private String name;
    private StudentUnit unit;
    private Long index;
    private String email;
    private String phoneNumber;

    public CreateStudent(StudentDto studentDto) {
        this.name = studentDto.getName();
        this.unit = studentDto.getUnit();
        this.index = studentDto.getIndex();
        this.email = studentDto.getEmail();
        this.phoneNumber = studentDto.getPhoneNumber();
    }
}