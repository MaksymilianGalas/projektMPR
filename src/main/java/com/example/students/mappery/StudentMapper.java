package com.example.students.mappery;

import com.example.students.data.Student;
import com.example.students.resource.CreateStudent;
import com.example.students.resource.StudentDto;
import org.springframework.stereotype.Component;

//nasze dto muszą zostać w jakiś sposób zmapowane na encje i my robimy to ręcznie tworząc obiekty
@Component
public class StudentMapper {

    public StudentDto toDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getUnit(),
                student.getIndex(),
                student.getEmail(),
                student.getPhoneNumber()
        );
    }

    public Student toEntity(CreateStudent createStudent) {
        return new Student(createStudent.getName(), createStudent.getUnit(), createStudent.getIndex(), createStudent.getEmail(), createStudent.getPhoneNumber());
    }

    public void updateEntity(Student existingStudent, CreateStudent updateStudent) {
        if (updateStudent.getName() != null) {
            existingStudent.setName(updateStudent.getName());
        }
        if (updateStudent.getUnit() != null) {
            existingStudent.setUnit(updateStudent.getUnit());
        }
        if (updateStudent.getIndex() != null) {
            existingStudent.setIndex(updateStudent.getIndex());
        }
        if (updateStudent.getEmail() != null) {
            existingStudent.setEmail(updateStudent.getEmail());
        }
        if (updateStudent.getPhoneNumber() != null) {
            existingStudent.setPhoneNumber(updateStudent.getPhoneNumber());
        }

    }
}
