package com.example.students.service;

import com.example.students.data.*;
import com.example.students.exception.ResourceNotFoundException;
import com.example.students.mappery.FriendMapper;
import com.example.students.mappery.StudentMapper;
import com.example.students.resource.FriendDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendsService {



    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final FriendMapper friendMapper;
    private final FriendsRepository friendsRepository;

    public Friends getStudentByIdNoDto(UUID id) {
        return friendsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student " + id + "not found"));
    }

    private Long createIndex(StudentUnit unit) {
        var maxIndex = studentRepository.findMaxIndex().orElse(1L);
        if (StudentUnit.GDANSK.equals(unit)) {
            return 5 * maxIndex;
        } else {
            return 10 * maxIndex;
        }
    }
    public List<FriendDto> findFriendsDtoById(UUID Id) {
        List<Friends> friends = friendsRepository.findFriendsById(Id);
        if (friends.isEmpty()) {
            throw new ResourceNotFoundException("Friends not found for student with id: " + Id);
        }
        return friends.stream()
                .map(friendMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<Friends> findAssignmentsByStudentId(Assignment assignment) {
        List<Friends> assignments = friendsRepository.findAssignmentsByAssignment(assignment);
        if (assignments.isEmpty()) {
            throw new ResourceNotFoundException("Assignments not found for student with id: " + assignment);
        }
        return assignments;
    }


    public void deleteFriendByName(String name) {
        friendsRepository.deleteFriendsByName(name);
    }

}
