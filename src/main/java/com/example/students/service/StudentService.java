package com.example.students.service;

import com.example.students.data.*;
import com.example.students.exception.FriendNotFoundException;
import com.example.students.exception.ResourceNotFoundException;
import com.example.students.exception.StudentNotFoundException;
import com.example.students.mappery.FriendMapper;
import com.example.students.mappery.StudentMapper;
import com.example.students.resource.CreateFriend;
import com.example.students.resource.CreateStudent;
import com.example.students.resource.FriendDto;
import com.example.students.resource.StudentDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final FriendMapper friendMapper;


    public Student createStudent(CreateStudent createStudent) {
        var studentToSave = studentMapper.toEntity(createStudent);
        var index = createIndex(createStudent.getUnit());
        studentToSave.setIndex(index);
        studentRepository.save(studentToSave);
        return studentToSave;
    }

    public StudentDto getStudentById(UUID id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Student " + id + "not found"));
    }
    public Student getStudentByIdNoDto(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student " + id + "not found"));
    }
    public void deleteByName(String name) {
        var students = studentRepository.findByName(name);
        if(students.isEmpty()) {
            throw new StudentNotFoundException("Student with name " + name + " not found.");
        }
        studentRepository.deleteAll(students);
    }

    private Long createIndex(StudentUnit unit) {
        var maxIndex = studentRepository.findMaxIndex().orElse(1L);
        if (StudentUnit.GDANSK.equals(unit)) {
            return 5 * maxIndex;
        } else {
            return 10 * maxIndex;
        }
    }

    public List<StudentDto> getNameBy(String name) {
        return studentRepository.findFromGdanskByName(name)
                .stream().map(studentMapper::toDto)
                .toList();
    }

    public Friends addFriend(CreateFriend createFriend) {
        var friendToSave = friendMapper.toEntity(createFriend);
        var student = getStudentByIdNoDto(friendToSave.getId());
        student.getFriends().add(friendToSave);
        studentRepository.save(student);

        return friendToSave;
    }

    @Transactional
    public Student createStudentTransactional(CreateStudent createStudent) {
        var studentToSave = studentMapper.toEntity(createStudent);
        var index = createIndex(createStudent.getUnit());
        studentToSave.setIndex(index);
        studentRepository.save(studentToSave);
        return studentToSave;
    }

    public List<StudentDto> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateStudent(UUID id, CreateStudent student) {
        var studentToSave = studentMapper.toEntity(student);
        studentToSave.setId(id);
        studentRepository.save(studentToSave);
    }
}
